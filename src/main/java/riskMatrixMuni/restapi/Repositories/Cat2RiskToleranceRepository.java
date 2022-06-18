package riskMatrixMuni.restapi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.Cat2RiskTolerance;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

@Repository
public interface Cat2RiskToleranceRepository extends JpaRepository<Cat2RiskTolerance, CompositeKeyFirst> {

	@Query(value= "SELECT 	risk_tolerance_muni_id, risk_tolerance_id, risk_tolerance_description, risk_tolerance_min, "
			+ "risk_tolerance_max, risk_tolerance_criteria, risk_tolerance_priority_id"			
			+ "		FROM 	tbl_cat2_risk_tolerance  "
			+ "		WHERE  	risk_tolerance_muni_id 		= :muni_id"
			+ "		AND 	risk_tolerance_description	like :name ",nativeQuery = true)
    List<Cat2RiskTolerance> buscarxnombre(@Param("name") String name, long muni_id);
}
