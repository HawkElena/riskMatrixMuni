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
@Table(name = "tbl_cat2_area_evaluate")
@IdClass(CompositeKeyFirst.class)
public class Cat2AreaEvaluate {

	@Id
	@Column(name = "area_evaluate_muni_id")
	private long 	muni_id;
	
	@Id
	@Column(name = "area_evaluate_id")
	private long 	id;
	
	@Column(name = "area_evaluate_name")
	private String 	name;
	
	@Column(name = "area_evaluate_group_area_id")
	private long 	group_area_id;
	
	@Transient
	@Column(name = "_message")
	private String	_message			;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
}
