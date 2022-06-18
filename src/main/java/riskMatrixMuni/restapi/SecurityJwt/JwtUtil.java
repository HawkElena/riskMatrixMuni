package riskMatrixMuni.restapi.SecurityJwt;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

//T  and function doble collumns  java functional programming
//java return hired function investigate

@Component
public class JwtUtil {

	private static final String SECRET_KEY ="riskMatix";
	
	public String getUserNameFromToken(String token) {
	 
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	private <T> T getClaimFromToken(String token,Function<Claims, T> claimResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		
		return claimResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
//	
//	public boolean validateToken(String token, UserDetals UserDetails) {
//		String userName getUserNameFromToken(token) ;
//		
//		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token)    );
//	}
//	
//	private boolean isTokenExpired(String token) {
//		final Date expirationDate = getExpirationDateFromToken(token);
//		return exprirationDate.before(new Date());
//	}
//	
//	private Date getExpirationDateFromToken(String token) {
//		return getClaimsFromToken (token, Claims::getExpiration);
//	}
}