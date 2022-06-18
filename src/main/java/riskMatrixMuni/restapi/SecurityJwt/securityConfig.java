package riskMatrixMuni.restapi.SecurityJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class securityConfig extends WebSecurityConfigurerAdapter{

	//aca es donde hace las validaciones de loadby user name
	@Autowired
	CustomUserDetailService userDetailService;
	
	//viene de la clase que se creo en jwt s
	@Autowired
	private JwtAutenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	//aca es donde valida el usuario y password
	public JwtAuthenticationFilter jwtAuthenticationFilter() {  
		return new JwtAuthenticationFilter(); 
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests().antMatchers("/auth/**").permitAll()
		.antMatchers(HttpMethod.GET,"/**").permitAll()
		.antMatchers(HttpHeaders.ALLOW).permitAll()
		.anyRequest()
		.authenticated();
		
		//se quita la autenticacion basica 
//		.and()
//		.httpBasic();
	
//		ahora se encarga el jwt
		http.addFilterBefore(jwtAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
		//super.configure(http);
	}
	
	
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		UserDetails hawk = User.builder()
//				.username("User")
//				.password(passwordEncoder().encode("hawkUser"))
//				.roles("USER").build();
//	
//		UserDetails hawkAdmin = User.builder()
//				.username("Admin")
//				.password(passwordEncoder().encode("hawkAdmin"))
//				.roles("ADMIN").build();
//	
//		return  new InMemoryUserDetailsManager(hawk,hawkAdmin);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
		
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
}
