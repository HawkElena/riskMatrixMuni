package riskMatrixMuni.restapi.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class JwtAuthResponseDTO {

	private String 	accessToken;
	private String 	typeToken = "Bearer";
	private boolean	Expiration;
	private String	fechaExpiration;
	private String	userNameorEmail ;
	private String	rolUser;
	private int  	rolUserId;
	
	public JwtAuthResponseDTO(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
	
}
	
