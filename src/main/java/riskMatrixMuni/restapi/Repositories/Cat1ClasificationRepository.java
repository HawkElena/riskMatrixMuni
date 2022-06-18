package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.Cat1Clasification;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

@Repository
public interface Cat1ClasificationRepository extends JpaRepository<Cat1Clasification, CompositeKeyFirst> {

	public Optional<Cat1Clasification> findByName(String name);
	
	public List<Cat1Clasification> findByNameContaining(String name);
	public List<Cat1Clasification> findByNameIsContaining(String name);
	public List<Cat1Clasification> findByNameLike(String name);
	
	
	@Query(value= "SELECT 	clasication_muni_id, clasification_id, classification_name "
			+ "		FROM 	tbl_cat1_clasification  "
			+ "		WHERE  	clasication_muni_id = :muni_id"
			+ "		AND 	classification_name like :name ",nativeQuery = true)
    List<Cat1Clasification> buscarxnombre(@Param("name") String name, long muni_id);
}
