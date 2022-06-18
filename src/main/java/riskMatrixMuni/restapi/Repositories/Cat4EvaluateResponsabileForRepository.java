package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import riskMatrixMuni.restapi.Models.Cat4EvaluateResponsabilefor;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat4EvaluateResponsabileForRepository extends JpaRepository<Cat4EvaluateResponsabilefor, CompositeKeyFirst> {

	
	@Query(value= "select  a.resp_position_muni_id 	muni_id 			"
			+ "		,a.resp_position_id  			resp_position_id  	"
			+ "		, b.position_name  				_position_name		"
			+ "		,a.resp_position_eval_plann_id 	evaluation_plan_id	"			
			+ "from    tbl_muni_det_responsiblefor         a 						"
			+ "        left join tbl_cat1_positions        b   	on 					"
			+ "            a.resp_position_muni_id         =   	b.position_muni_id 	"
			+ "            and a.resp_position_id          =	b.position_id 		"
			+ "where   a.resp_position_muni_id             = 	:muni_id					"
			+ "and     case when isnull(:evaluation_plan_id)     = 	1     then 1=1    else    a.resp_position_eval_plann_id           =   :evaluation_plan_id  end "
			+ "and     case when isnull(:resp_position_id)     = 	1     then 1=1    else    a.resp_position_id                      =   :resp_position_id   end "
			,nativeQuery = true)
	List<Map<String, ?>> procListarPosition (
			@Param("muni_id")				long	muni_id
			,@Param("evaluation_plan_id")	long	evaluation_plan_id
			,@Param("resp_position_id")		long	resp_position_id															
															);
	
	
//	Cat4EvaluateResponsabilefor save (Cat4EvaluateResponsabilefor pEntity);
		
	
}
