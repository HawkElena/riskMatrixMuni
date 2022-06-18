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
@Table(name = "tbl_muni_det_resource_type")
@IdClass(CompositeKeyFirst.class)
public class ResourceType {

	@Id
	@Column(name = "resource_type_muni_id")	      
	private long muni_id;
	
	@Id
	@Column(name = "resources_type_id")	      	           
	private long id;           
	
	@Column(name = "resource_type_descryption")	      	           	  
	private String description;  
	
	@Column(name = "resource_type_is_external")	      	           	  	          
	private float min;
	
	@Column(name = "resource_type_eval_plann_id")	      	           	  	          
	private float risk_tolerance_max;          
	
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
