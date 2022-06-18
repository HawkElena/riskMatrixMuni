package riskMatrixMuni.restapi.Exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	

	private HttpStatus  estado;
	private String		mensaje;
	
	public AppException ( HttpStatus estado , String mensaje , String mensaje1) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
		this.mensaje = mensaje1;
	}
}