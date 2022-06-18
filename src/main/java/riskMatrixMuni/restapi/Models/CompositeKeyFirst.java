package riskMatrixMuni.restapi.Models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class CompositeKeyFirst implements Serializable {
	     /**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	long muni_id = 1;
//	BigDecimal
	long id 	= 1;

}
