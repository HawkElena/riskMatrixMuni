package riskMatrixMuni.restapi.SecurityJwt;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import riskMatrixMuni.restapi.Models.Roles;
import riskMatrixMuni.restapi.Models.Usuarios;
import riskMatrixMuni.restapi.Repositories.RolesRepository;
import riskMatrixMuni.restapi.Repositories.UsuariosRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UsuariosRepository usuarioRepositorio;
	
	@Autowired
	RolesRepository rolRepository;

//	@Autowired
//	UsuarioRolRepository userRolRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// aqui hace el logeo para la base de datos.
		Usuarios usuarios = usuarioRepositorio.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese usuername o email:"  + usernameOrEmail));

		//ir a traer el role por usuario
//		UserRol userRol = userRolRepository.findByUsuarioid(usuarios.getUsuario_id())
//				.orElseThrow(() -> new UsernameNotFoundException("usuario rol no encontrado"  + usuarios.getUsuario_id()));
					;
//		Rol rol = rolRepository.findById(userRol.getRolid()).get();
		
		
		
		//return new User(usuarios.getEmail(),usuarios.getPassword(),mapearUsuarioRol(rol));
		return new User(usuarios.getEmail(),usuarios.getPassword(),mapearRoles(usuarios.getRoles()));

	}
	
	private Collection<? extends GrantedAuthority> mapearRoles(Set<Roles> roles){
		return roles.stream().map(rol -> 
					new SimpleGrantedAuthority(
												rol.getNombre())).collect(Collectors.toList()
											  );
	}

}
