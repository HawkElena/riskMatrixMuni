package riskMatrixMuni.restapi.Models;

import java.util.HashSet;
import java.util.Set;

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
	@Table(name = "tbl_mun_evaluation_plan")
	@IdClass(CompositeKeyFirst.class)


	public class Cat4EvaluatePlan {

		@Id
		@Column(name = "eval_plann_muni_id")
		private long 	muni_id ;//si
		
		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "eval_plann_id")
		private long 	id      ;//si
			
		@Column(name = "eval_plann_recomendations")
		private String 	recomendations ;//si
		
		@Column(name = "eval_plann_implement_control")
		private String 	implement_control;//si
		
		@Column(name = "eval_plann_priority_id")
		private long 	priority_id ;//si
		
		@Column(name = "eval_plann_startdate")
		private String 	startdate ;//si
		
		@Column(name = "eval_plann_enddate")
		private String 	enddate; //si
		
		@Column(name = "eval_plann_remarks")
		private String 	remarks;//si
		
		@Column(name = "eval_plan_eval_matrix_id")
		private long 	matrix_id ;//si
		
		
		@Transient
		@Column(name = "_priority_name")
		private String	_priority_name			;
		
		@Transient
		@Column(name = "_matrix_riesgo")
		private String	_matrix_riesgo			;
		
		@Transient
		@Column(name = "_matrix")
		private String	_matrix					;
		
		@Transient
		private Set<Cat4EvaluateResponsabilefor> positions = new HashSet<>(); 
		
		@Transient
		@Column(name = "_riesgo_residual")
		private String	_riesgo_residual					;
		
		@Transient
		@Column(name = "_message")
		private String	_message				;
		
		@Transient
		@Column(name = "opcionDML")
		private int		_opcionDML				;
		
		
	}
