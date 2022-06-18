package riskMatrixMuni.restapi.SecurityJwt;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import riskMatrixMuni.restapi.Exceptions.AppException;


@Component
public class JwtTokenProvider {

	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpirationInMs;


	public String generarToken(Authentication authenticaction ) {
		String username = authenticaction.getName();
//		Date fechaActual = new Date();
//		Date fechaExpiration = new Date(fechaActual.getTime()+ jwtExpirationInMs);
//		
		Date fechaActualD = new Date();
		Date fechaExpirationD = new Date(fechaActualD.getTime()+ jwtExpirationInMs);
		
		String fechaExpiration = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(fechaExpirationD);
		String fechaActual = new SimpleDateFormat("dd-MM-yyy - HH:mm:ss").format( fechaActualD);
		
		String token  = Jwts.builder()
						.setSubject(username)
						.claim("username", username)
						.claim("fechaExpiracion", fechaExpiration)
						.claim("fechaActual", fechaActual)						
						.setIssuedAt(new Date())
						.setExpiration(fechaExpirationD)
						
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		
		return token;
	}
	
	public String ObtenerUserNameDelJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public Date getBestByDateOfJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getExpiration();
	}
	public boolean validarToken(String token) {
		
		try {
			Jwts.parser().setSigningKey(jwtSecret).parse(token);
			return true;
		} catch (SignatureException ex) {
			throw new AppException(HttpStatus.BAD_REQUEST,"Firma no valida");			
		} catch (MalformedJwtException ex) {
			throw new AppException(HttpStatus.BAD_REQUEST,"Token no valido");
		} catch (ExpiredJwtException ex) {
			throw new AppException(HttpStatus.BAD_REQUEST,"Token ya expiro");
		}catch (UnsupportedJwtException ex) {
			throw new AppException(HttpStatus.BAD_REQUEST,"Token no compatible");
		}catch (IllegalArgumentException ex) {
			throw new AppException(HttpStatus.BAD_REQUEST,"claims vacios");
		}
	}
}
