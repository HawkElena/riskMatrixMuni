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
@Table(name = "tbl_muni_det_responsiblefor")
@IdClass(CompositeKeySecond.class)

public class Cat4EvaluateResponsabilefor {

	@Id
	@Column(name = "resp_position_muni_id")
	private long 	muni_id ;//si
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resp_position_id")
	private long 	resp_position_id      ;//si

	@Id	
	@Column(name = "resp_position_eval_plann_id")
	private long 	evaluation_plan_id ;//si

	
	@Transient
	@Column(name = "_position_name")
	private String 	_position_name ;//si
	
	@Transient
	@Column(name = "_message")
	private String	_message				;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML				;
}
