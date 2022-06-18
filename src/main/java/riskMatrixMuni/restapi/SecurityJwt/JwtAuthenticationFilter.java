package riskMatrixMuni.restapi.SecurityJwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private CustomUserDetailService  customUserDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//obtener el token
		String token = obtenerJwtRequest(request);
		
		//validar token
		if(StringUtils.hasText(token) && jwtTokenProvider.validarToken(token)) {
			//obtener el usuario que trae el token
			String username = jwtTokenProvider.ObtenerUserNameDelJWT(token);
			
			//obtener el usuario que se asocio dentro del token en la base de datos.
			UserDetails userDetail = customUserDetailService.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(
					userDetail
					, null
					,userDetail.getAuthorities()
					);
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			//establecer la seguridad
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			
		}
		filterChain.doFilter(request, response);
		
	}

	//bearer token de acceso
	private String obtenerJwtRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring(7,bearerToken.length());
		}
		return null;
	}
	
}
