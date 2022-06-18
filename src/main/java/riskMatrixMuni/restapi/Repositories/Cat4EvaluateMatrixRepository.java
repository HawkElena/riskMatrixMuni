package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.Cat4EvaluateMatrix;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

@Repository
public interface Cat4EvaluateMatrixRepository extends JpaRepository<Cat4EvaluateMatrix, CompositeKeyFirst> {

	
	
	@Query(value ="{call sp_mun_getEvaluateMatrix  (:_muni_id,"
													+ ":_event_ids,"
													+ ":_prob_id,"
													+ ":_sever_id,"
													+ ":_event_desc,"
													+ ":_area_name,"
													+ ":_group_name,"
													+ ":_prob_puntaje,"
													+ ":_sever_puntaje)}", nativeQuery = true)
    List<Map<String, ?>> procListarEvaluateMatrix( 
													@Param("_muni_id")				long	_muni_id
													,@Param("_event_ids")			long	_event_ids
													,@Param("_prob_id")				long	_prob_id
													,@Param("_sever_id")			long	_sever_id
													,@Param("_event_desc")			String	_event_desc
													,@Param("_area_name")			String	_area_name
													,@Param("_group_name")			String	_group_name
													,@Param("_prob_puntaje")		int		_prob_puntaje
													,@Param("_sever_puntaje")		int		_sever_puntaje													
													);
	
	
	@Query(value= "SELECT 	ifnull(max( evaluate_matrix_id ),0) + 1  cuenta "
			+ "		FROM 	tbl_mun_evaluate_matrix  "
			+ "		WHERE  	evaluate_matrix_muni_id = :muni_id ",nativeQuery = true)
	public long max(@Param("muni_id")  long muni_id);
}
