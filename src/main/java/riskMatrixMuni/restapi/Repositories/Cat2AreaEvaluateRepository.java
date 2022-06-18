package riskMatrixMuni.restapi.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.Cat2AreaEvaluate;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

@Repository
public interface Cat2AreaEvaluateRepository extends JpaRepository<Cat2AreaEvaluate, CompositeKeyFirst> {

//	public Optional<Cat2AreaEvaluate> findByNameAndFk_id(String name, long fk_id);
	
//	public List<Cat2AreaEvaluate> findByNameAndGroup_area_idContaining(String name, long group_area_id);
//	public List<Cat2AreaEvaluate> findByNameAndGroup_area_idIsContaining(String name,long group_area_id);
//	public List<Cat2AreaEvaluate> findByNameAndGroup_area_idLike(String name, long group_area_id);
	
	@Query(value= "SELECT 	area_evaluate_muni_id, area_evaluate_id, area_evaluate_name,area_evaluate_group_area_id "
			+ "		FROM 	tbl_cat2_area_evaluate  "
			+ "		WHERE  	area_evaluate_muni_id 		= :muni_id"
			+ "		AND 	area_evaluate_name like :name ",nativeQuery = true)
    List<Cat2AreaEvaluate> buscarxnombre(@Param("name") String name, long muni_id);
	
	@Query(value= "SELECT 	area_evaluate_muni_id, area_evaluate_id, area_evaluate_name,area_evaluate_group_area_id "
			+ "		FROM 	tbl_cat2_area_evaluate  "
			+ "		WHERE  	area_evaluate_muni_id 		= :muni_id"
			+ "		AND 	area_evaluate_group_area_id = :group_area_id ",nativeQuery = true)
    List<Cat2AreaEvaluate> buscarxGropuId(@Param("group_area_id") long group_area_id, long muni_id);
	
}
