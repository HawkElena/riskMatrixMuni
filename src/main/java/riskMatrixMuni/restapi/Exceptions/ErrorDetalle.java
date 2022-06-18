package riskMatrixMuni.restapi.Exceptions;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ErrorDetalle {
	private Date marcaDeTiempo;
	private String mensaje;
	private String detalles;
	public ErrorDetalle(Date marcaDeTiempo, String mensaje, String detalles) {
		super();
		this.marcaDeTiempo = marcaDeTiempo;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}

	
}
