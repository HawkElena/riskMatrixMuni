package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1MatureCriteria;

public interface Cat1MatureCriteriaRepository extends JpaRepository<Cat1MatureCriteria, CompositeKeyFirst> {

	
	public Optional<Cat1MatureCriteria> findByName(String name);
	
	public List<Cat1MatureCriteria> findByNameContaining(String name);
	public List<Cat1MatureCriteria> findByNameIsContaining(String name);
	public List<Cat1MatureCriteria> findByNameLike(String name);
	
	
	@Query(value= "SELECT 	mature_criteria_muni_id, mature_criteria_id, mature_criteria_name "
			+ "		FROM 	tbl_cat1_mature_criteria  "
			+ "		WHERE  	mature_criteria_muni_id = :muni_id"
			+ "		AND 	mature_criteria_name like :name ",nativeQuery = true)
    List<Cat1MatureCriteria> buscarxnombre(@Param("name") String name, long muni_id);
}
