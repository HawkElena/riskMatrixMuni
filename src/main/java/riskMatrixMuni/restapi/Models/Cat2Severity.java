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
@Table(name = "tbl_cat2_severities")
@IdClass(CompositeKeyFirst.class)

public class Cat2Severity {

	@Id
	@Column(name = "sever_muni_id")
	private long 	muni_id;
	
	@Id
	@Column(name = "sever_id")
	private long 	id;
	
	@Column(name = "sever_name")
	private String 	name;
	
	@Column(name = "sever_clasif_id")
	private int 	clasif_id;
	
	@Column(name = "sever_puntaje")
	private int 	puntaje;
	
	@Transient
	@Column(name = "_message")
	private String	_message			;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
}
