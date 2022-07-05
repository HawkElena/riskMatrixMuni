package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1GroupArea;

@Repository
public interface Cat1GroupAreaRepository extends JpaRepository<Cat1GroupArea, CompositeKeyFirst> {
	
	public Optional<Cat1GroupArea> findByName(String name);
	
	public List<Cat1GroupArea> findByNameContaining(String name);
	public List<Cat1GroupArea> findByNameIsContaining(String name);
	public List<Cat1GroupArea> findByNameLike(String name);
	
	
	@Query(value= "SELECT 	group_area_muni_id, group_area_id, area_group_name "
			+ "		FROM 	tbl_cat1_group_area  "
			+ "		WHERE  	group_area_muni_id = :muni_id"
			+ "		AND 	area_group_name like :name ",nativeQuery = true)
    List<Cat1GroupArea> buscarxnombre(@Param("name") String name, long muni_id);
	
	
	@Query(value= "SELECT 	ifnull(max(group_area_id),0) + 1  cuenta "
			+ "		FROM 	tbl_cat1_group_area  "
			+ "		WHERE  	group_area_muni_id = :muni_id ",nativeQuery = true)
	public long max(@Param("muni_id")  long muni_id);

	
}
