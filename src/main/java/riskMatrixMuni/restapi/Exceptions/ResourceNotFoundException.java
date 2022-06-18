package riskMatrixMuni.restapi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID= 1L;
	private String nombreDelRecurso;
	private String nombreDelCampo;
	private long valorDelCampo;
	
	public ResourceNotFoundException (String nombreDelRecurso,  String nombreDelCampo, long valorDelCampo) {
		super(String.format("%s No encontrado con : %s : '%s'",nombreDelRecurso,nombreDelCampo,valorDelCampo));
		this.nombreDelCampo = nombreDelCampo;
		this.nombreDelRecurso = nombreDelRecurso;
		this.valorDelCampo = valorDelCampo;
				
	}
}
