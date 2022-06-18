package riskMatrixMuni.restapi.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Cat4EvaluateMatrixRequestDTO {

	private long 	_muni_id;
	private long 	_event_ids;
	private long 	_prob_id; 
	private long 	_sever_id;
	private String 	_event_desc;
	private String 	_area_name;
	private String 	_group_name ;
	private int 	_prob_puntaje; 
	private int 	_sever_puntaje;
	
}
