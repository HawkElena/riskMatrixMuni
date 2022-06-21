package riskMatrixMuni.restapi.Controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import riskMatrixMuni.restapi.Models.Roles;
import riskMatrixMuni.restapi.Models.Usuarios;
import riskMatrixMuni.restapi.Repositories.RolesRepository;
import riskMatrixMuni.restapi.Repositories.UsuariosRepository;
import riskMatrixMuni.restapi.Responses.JwtAuthResponseDTO;
import riskMatrixMuni.restapi.Responses.LoginDTO;
import riskMatrixMuni.restapi.Responses.RegistroDTO;
import riskMatrixMuni.restapi.SecurityJwt.JwtTokenProvider;


@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	//para validar el usuario y elpassword
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuariosRepository usuarioRepository;
	
	@Autowired
	PasswordEncoder	passwordEncoder;
	
	@Autowired
	RolesRepository rolRepository;
	
	
	@Autowired
	//para realizar set y get de los claims
	JwtTokenProvider jwtTokenProvider;

	@PostMapping("/iniciarSesion")
	public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
//		try {
			
			Authentication  authentication = authenticationManager
					.authenticate(
								new UsernamePasswordAuthenticationToken(
										loginDTO.getUsernameOrEmail(), 
										loginDTO.getPassword())
									);

			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			//aqui hay que obtener el token aca es donde se le pueden enviar los diferentes claims 
			//evaluar si aca es donde se le puede tambin enviar el rol y el password
			String token = jwtTokenProvider.generarToken(authentication);
			//return new ResponseEntity<>("Ha iniciado sesion con exito...!"+ authentication, HttpStatus.OK);	

			//mostrar los valores que llevara de respuesta
			JwtAuthResponseDTO jwtAuthResponseDTO = new JwtAuthResponseDTO(token);
			jwtAuthResponseDTO.setUserNameorEmail(loginDTO.getUsernameOrEmail());
			
			
//			//add today 03/31/22 
//			//ir a traer el role por usuario
			Usuarios usrlog = usuarioRepository.findByUsernameOrEmail(loginDTO.getUsernameOrEmail().toString()
																	  ,loginDTO.getUsernameOrEmail().toString())
					.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese usuername o email:"+loginDTO.getUsernameOrEmail().toString()));
			
			
//			se pudo leer el valor directo a un entero  intRolId = usrlog.getRoles().stream().map(rol -> rol.getId()).toList().get(0);
//			List<Integer> RolId = usrlog.getRoles().stream().map(rol -> rol.getId()).toList();
			List<Integer> RolId = usrlog.getRoles().stream().map(rol -> rol.getId()).collect(Collectors.toList());
			List<String> RolNombre = usrlog.getRoles().stream().map(rol -> rol.getNombre()).collect(Collectors.toList());
			
			jwtAuthResponseDTO.setRolUser(RolNombre.get(0));
			jwtAuthResponseDTO.setRolUserId(RolId.get(0));
			Date fechaExpiration= jwtTokenProvider.getBestByDateOfJWT(token);
			jwtAuthResponseDTO.setFechaExpiration(new SimpleDateFormat("dd-MM-yyyy - HH:mm:ss").format(fechaExpiration));
			
			return ResponseEntity.ok(jwtAuthResponseDTO);
		
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO){
		if(usuarioRepository.existsByUsername(registroDTO.getUsername()))
		{
			return new ResponseEntity<>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
			
		};
		
		if(usuarioRepository.existsByEmail(registroDTO.getEmail()))
		{
			return new ResponseEntity<>("Este email ya existe", HttpStatus.BAD_REQUEST);
			
		};
		
		if(!rolRepository.existsById(registroDTO.getRol_id())) {
			return new ResponseEntity<> ("El rol que asigno al usuario no existe..",HttpStatus.BAD_REQUEST);
		};
		
		Usuarios usuario = new Usuarios();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setUsername(registroDTO.getUsername());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword( passwordEncoder.encode( registroDTO.getPassword()));
		
//		//add today 03/31/22 
//		Rol roles = new Rol();
//		roles = rolRepository.findById(registroDTO.getRol_id()).get();
//		
//		usuario.setRoles_id(roles.getId());
		
		//Rol roles = rolRepository.findByNombre("ROLE_ADMIN").get();
		Roles roles = rolRepository.findById(registroDTO.getRol_id()).get();
		usuario.setRoles(Collections.singleton(roles));
		
		usuario = usuarioRepository.save(usuario);
		
//		//obtenemos el usuario id que se ingreso
//		Usuarios  usertemp = new Usuarios();
//		
//		usertemp = usuarioRepository.findByUsernameOrEmail(registroDTO.getUsername().toString(),registroDTO.getEmail().toString())
//						.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese usuername o email:"+ registroDTO.getUsername().toString()));
//		//creamoe el modelo de usuariorol
//		
//		UserRol userRol = new UserRol();
//		userRol.setRolid(usertemp.getRoles_id());
//		userRol.setUsuarioid(usertemp.getUsuario_id());
//		//guardamos el usuario rol
//		usuarioRolRepository.save(userRol);
		 
		return new ResponseEntity<>("Usuario registrado con exito = " + usuario.getUsuario_id() ,HttpStatus.OK);
	}

}
