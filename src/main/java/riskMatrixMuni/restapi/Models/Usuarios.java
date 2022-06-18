package riskMatrixMuni.restapi.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table	(	name="tbl_usuarios" , 
			uniqueConstraints = {	@UniqueConstraint(columnNames = {"username"}),
									@UniqueConstraint(columnNames = {"email"})
								}
		)

@Setter
@Getter
@NoArgsConstructor
public class Usuarios {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int 	usuario_id;
		private String	nombre;
		private String 	username;
		private String 	email;
		private String 	password;
		@Transient
		private int  	roles_id;
		
		@ManyToMany(fetch= FetchType.EAGER,cascade = CascadeType.ALL )
		@JoinTable(	name 				= "tbl_usuario_roles", 
					joinColumns 		= @JoinColumn(name= "usuario_id"	,referencedColumnName = "usuario_id"), 
					inverseJoinColumns 	= @JoinColumn(name= "roles_id"		,referencedColumnName = "roles_id")
					)
		
		private Set<Roles> roles = new HashSet<>(); 
		
		
}
