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
@Table(name = "tbl_cat2_risk_tolerance")
@IdClass(CompositeKeyFirst.class)

public class Cat2RiskTolerance {

	@Id
	@Column(name = "risk_tolerance_muni_id")	      
	private long muni_id;
	
	@Id
	@Column(name = "risk_tolerance_id")	      	           
	private long id;           
	
	@Column(name = "risk_tolerance_description")	      	           	  
	private String description;  
	
	@Column(name = "risk_tolerance_min")	      	           	  	          
	private float min;
	
	@Column(name = "risk_tolerance_max")	      	           	  	          
	private float max;          
	
	@Column(name = "risk_tolerance_criteria")	      	           	  	     
	private String criteria;     
	
	@Column(name = "risk_tolerance_priority_id")	      	           	  	  
	private int priority_id;  
	
	@Transient
	@Column(name = "_message")
	private String	_message			;
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
}
