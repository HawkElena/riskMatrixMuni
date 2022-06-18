package riskMatrixMuni.restapi.Request;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import riskMatrixMuni.restapi.Models.Cat4EvaluateResponsabilefor;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Cat4EvaluatePlanRequestDTO {

	private	long								_muni_id;
	private	String								_startDate;
	private	String								_endDate;
	private	String								_controlRecomend;
	private	String								_riesgo;
	private	long								_matrixa_id;
	private	String								_priority_name;
	private Set<Cat4EvaluateResponsabilefor> 	_positions = new HashSet<>();
}
