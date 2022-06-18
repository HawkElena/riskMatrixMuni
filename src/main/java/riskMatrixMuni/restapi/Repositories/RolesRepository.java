package riskMatrixMuni.restapi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
	public Optional<Roles> findByNombre(String nombre);
	public Optional<Roles> findById(int id); //add today 03/31/22
	public Boolean existsById(int id); //add today 03/31/22
	//public Boolean notExistsByRol_id(int rol_id);//add today 03/31/22
//	return new ResponseEntity<>("Usuario registrado con exito",HttpStatus.OK);
	
	public void deleteById(Integer id);
	//public Integer save();
	
	//public Optional <Rol> getAllRols();
}
