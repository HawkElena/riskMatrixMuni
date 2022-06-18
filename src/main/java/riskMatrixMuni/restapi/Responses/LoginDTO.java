package riskMatrixMuni.restapi.Responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginDTO {

	private String usernameOrEmail;
	private String password;
	private String rol_id;
	private String rol_name;
		
	
}