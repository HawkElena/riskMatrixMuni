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
@Table(name = "tbl_cat1_positions")
@IdClass(CompositeKeyFirst.class)

public class Cat1Position {

	@Id
	@Column(name = "position_muni_id")
	private long 	muni_id;
	
	@Id
	@Column(name = "position_id")
	private long 	id;
	
	@Column(name = "position_name")
	private String 	name;
	
	@Transient
	@Column(name = "_message")
	private String	_message			;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
}
