package riskMatrixMuni.restapi.Models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Data
@Table(name = "tbl_mun_evaluate_matrix")
@IdClass(CompositeKeyFirst.class)


public class Cat4EvaluateMatrix {

	@Id
	@Column(name = "evaluate_matrix_muni_id")
	private long 	muni_id ;//si
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evaluate_matrix_id")
	private long 	id      ;//si
		
	@Column(name = "evaluate_matrix_event_id")
	private long 	event_id ;//si
	
	@Column(name = "evaluate_matrix_description_risk")
	private String 	descriptionRisk;//si
	
	@Column(name = "evaluate_matrix_prob_id")
	private long 	probId ;//si
	
	@Column(name = "evaluate_matrix_sever_id")
	private long 	severId ;//si
	
	//this atribute may be is calculated but doest not need enter any value directly in the interface
	@Column(name = "evaluate_matrix_inherent_risk")
	private long 	inherentRisk; //si
	
//	this atribute definitly doest not need enter any value directly in the interface
	@Column(name = "evaluate_matrix_calc_residual_risk")
	private float 	calcResidualRisk;//si
	
	@Column(name = "evaluate_matrix_risk_tolerance_id")
	private long 	toleranceId ;//si
	
	@Column(name = "evaluate_matrix_internal_contoll_mitigate")
	private String 	internalContollMitigate ;//si
	
	@Column(name = "evaluate_risk_remarks")
	private String 	riskRemarks   ;//si
	
	@Transient
	@Column(name = "_group_id")
	private String 	_group_id   ;
	
	@Transient
	@Column(name = "_area_group_name")
	private String 	_group_name   ;

	@Transient
	@Column(name = "_area_id")
	private String 	_area_id   ;
	
	@Transient
	@Column(name = "_area_evaluate_name")
	private String 	_area_evaluate_name   ;
	
	@Transient
	@Column(name = "_event_description")
	private String 	_event_description   ;
	
	@Transient
	@Column(name = "_probabilidad")
	private int 	_probabilidad   ;

	@Transient
	@Column(name = "_severity")
	private int 	_severity   ;
	
	@Transient
	@Column(name = "_valor_mitigador")
	private String 	_valor_mitigador   ;
		
	@Transient
	@Column(name = "_riesgo_residual")
	private String 	_riesgo_residual   ;
	
	@Transient
	@Column(name = "_risk_tolerance_criteria")
	private String 	_risk_tolerance_criteria   ;
	
	@Transient
	@Column(name = "_message")
	private String	_message			;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
	
	
}
