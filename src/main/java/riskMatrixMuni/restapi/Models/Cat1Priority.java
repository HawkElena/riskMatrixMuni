package riskMatrixMuni.restapi.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.web.SortDefault.SortDefaults;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Data
@Table(name = "tbl_cat1_priorities")
@IdClass(CompositeKeyFirst.class)

public class Cat1Priority {

	@Id
	@Column(name = "prior_muni_id")
	private long 	muni_id;
	
	@Id
	@Column(name = "prior_id")
	private long 	id;
	
	@Column(name = "prior_namr")
	private String 	name;
	
//	@DefaultValue = null;
	@Column(name = "prior_tabla_id")
	private int 	tabla_id;
	
	@Transient
	@Column(name = "_message")
	private String	_message			;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
}
