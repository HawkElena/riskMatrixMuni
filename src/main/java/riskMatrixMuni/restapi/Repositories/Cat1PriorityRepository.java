package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1Priority;

public interface Cat1PriorityRepository extends JpaRepository<Cat1Priority, CompositeKeyFirst> {

	
	public Optional<Cat1Priority> findByName(String name);
	
	public List<Cat1Priority> findByNameContaining(String name);
	public List<Cat1Priority> findByNameIsContaining(String name);
	public List<Cat1Priority> findByNameLike(String name);
	
	
	@Query(value= "SELECT 	prior_muni_id, prior_id, prior_namr,prior_tabla_id"
			+ "		FROM 	tbl_cat1_priorities  "
			+ "		WHERE  	prior_muni_id 	= :muni_id"			
			+ "		AND  	case when :tabla_id = 0  then 1 = 1 else prior_tabla_id 	= :tabla_id end"
			+ "		AND 	prior_namr like :name ",nativeQuery = true)
    List<Cat1Priority> buscarxnombre(@Param("name") String name, @Param("muni_id") long muni_id,@Param("tabla_id") int tabla_id);
}
