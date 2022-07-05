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
@Table(name = "tbl_cat3_events")
@IdClass(CompositeKeyFirst.class)

public class Cat3Event {

	@Id
	@Column(name = "event_muni_id")
	private long 	muni_id;
	
	@Id
	@Column(name = "event_id")
	private long 	id;
	
	@Column(name = "event_description")
	private String 	name;
	
	@Column(name = "event_area_evaluate_id")
	private int 	evaluate_id;
	
	@Transient
	@Column(name = "_group_id")
	private long	_group_id			;
	
	@Transient
	@Column(name = "_group_name")
	private String	_group_name			;
	
	@Transient
	@Column(name = "_area_name")
	private String	_area_name			;
	

	
	@Transient
	@Column(name = "_message")
	private String	_message			;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
}
