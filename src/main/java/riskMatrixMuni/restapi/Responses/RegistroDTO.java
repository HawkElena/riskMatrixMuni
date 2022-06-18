package riskMatrixMuni.restapi.Responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistroDTO {

	private String nombre;
	private String username;
	private String email;
	private String password;
	private int    rol_id;//add today 03/31/22
}
