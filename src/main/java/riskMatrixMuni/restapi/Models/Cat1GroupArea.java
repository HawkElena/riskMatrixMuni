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
@Table(name = "tbl_cat1_group_area")
@IdClass(CompositeKeyFirst.class)
public class Cat1GroupArea {

	@Id
	@Column(name = "group_area_muni_id")
	private long 	muni_id;
	
	@Id
	@Column(name = "group_area_id")
	private long 	id;
	
	@Column(name = "area_group_name")
	private String 	name;
	
	@Transient
	@Column(name = "_message")
	private String	_message			;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
	
//	https://stackoverflow.com/questions/41143913/sql-jpa-multiple-columns-as-primary-key

}



