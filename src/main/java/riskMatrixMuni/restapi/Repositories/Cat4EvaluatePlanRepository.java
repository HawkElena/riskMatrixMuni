package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.Cat4EvaluatePlan;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

@Repository
public interface  Cat4EvaluatePlanRepository extends JpaRepository<Cat4EvaluatePlan, CompositeKeyFirst> {

	@Query(value ="{call sp_mun_getEvaluatePlan  ("
			+ ":_muni_id,"
			+ ":_startDate,"
			+ ":_endDate,"
			+ ":_controlRecomend,"
			+ ":_riesgo,"
			+ ":_matrixa_id,"
			+ ":_priority_name"
			+ ")}", nativeQuery = true)
	
	List<Map<String, ?>> procListarEvaluatePlan( 
			@Param("_muni_id")				long	_muni_id
			,@Param("_startDate")			String	_startDate
			,@Param("_endDate")				String	_endDate
			,@Param("_controlRecomend")		String	_controlRecomend
			,@Param("_riesgo")				String	_riesgo
			,@Param("_matrixa_id")			long	_matrixa_id
			,@Param("_priority_name")		String	_priority_name
			);

	@Query(value= "SELECT 	ifnull(max( eval_plann_id ),0) + 1  cuenta "
			+ "		FROM 	tbl_mun_evaluation_plan  "
			+ "		WHERE  	eval_plann_muni_id = :muni_id ",nativeQuery = true)
	public long max(@Param("muni_id")  long muni_id);
}
