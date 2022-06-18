package riskMatrixMuni.restapi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat2Severity;

@Repository
public interface Cat2SeverityRepository extends JpaRepository<Cat2Severity, CompositeKeyFirst> {

	@Query(value= "SELECT 	sever_muni_id, sever_id, sever_name, sever_clasif_id,sever_puntaje "			
			+ "		FROM 	tbl_cat2_severities  "
			+ "		WHERE  	sever_muni_id		 	= :muni_id"
			+ "		AND 	sever_name				like :name ",nativeQuery = true)
    List<Cat2Severity> buscarxnombre(@Param("name") String name, long muni_id);
}
