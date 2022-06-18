package riskMatrixMuni.restapi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.Cat2Probability;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

@Repository
public interface Cat2ProbabilityRepository extends JpaRepository<Cat2Probability, CompositeKeyFirst> {

	@Query(value= "SELECT 	prob_muni_id, prob_id, proba_name,prob_clasif_id,prob_puntaje "
			+ "		FROM 	tbl_cat2_probabilities  "
			+ "		WHERE  	prob_muni_id		 		= :muni_id"
			+ "		AND 	proba_name					like :name ",nativeQuery = true)
    List<Cat2Probability> buscarxnombre(@Param("name") String name, long muni_id);
	
}
