package riskMatrixMuni.restapi.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tbl_roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roles_id")
	private int id;
	
	@Column(name = "roles_name")
	private String nombre;
	
	@Column(name = "roles_hospital_id")
	private int hospital_id;
	
	@Column(name = "roles_status")
	private boolean	status;
	
	
	@Transient
	@Column(name = "opcionDML")
	private int		_opcionDML			;
	
	@Transient
	@Column(name = "_error_id")
	private int _error_id				;

	@Transient
	@Column(name = "_error_msg")
	private String _error_msg			;
}