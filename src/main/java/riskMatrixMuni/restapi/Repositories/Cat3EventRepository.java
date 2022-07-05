package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import riskMatrixMuni.restapi.Models.Cat3Event;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat3EventRepository extends JpaRepository<Cat3Event, CompositeKeyFirst> {

	@Query(value= "SELECT 	event_muni_id, event_id, event_description, event_area_evaluate_id "			
			+ "		FROM 	tbl_cat3_events  "
			+ "		WHERE  	event_muni_id		 	= :muni_id"
			+ "		AND 	event_description		like :name ",nativeQuery = true)	
    List<Cat3Event> buscarxnombre(@Param ("name") String name, long muni_id);
	
	@Query(value= "SELECT 	event_muni_id, event_id, event_description, event_area_evaluate_id "			
			+ "		FROM 	tbl_cat3_events  "
			+ "		WHERE  	event_muni_id		 	= :muni_id"
			+ "		AND 	event_area_evaluate_id	= :evaluate_id ",nativeQuery = true)	
    List<Cat3Event> buscarxAreaEvaluate(@Param ("evaluate_id") long evaluate_id, long muni_id);		
	
	@Query(value= "SELECT  ifnull(max(event_id),0) + 1  cuenta "
			+ "		FROM    tbl_cat3_events "
			+ "		WHERE   event_muni_id  = :muni_id "
			,nativeQuery = true)
	public long max(@Param("muni_id")  long muni_id);			
		
	@Query(value ="{call sp_mun_getEvent ("
			+ ":_muni_id,"
			+ ":_group_id,"
			+ ":_evaluate_id,"
			+ ":_id,"
			+ ":_group_name,"
			+ ":_area_name,"
			+ ":_event_name"
			+ ")}", nativeQuery = true)	
	List<Map<String, ?>> procListarEvent( 
			@Param("_muni_id")			long	_muni_id
			,@Param("_group_id")		long	_group_id
			,@Param("_evaluate_id")		long	_evaluate_id
			,@Param("_id")				long	_id
			,@Param("_group_name")		String	_group_name
			,@Param("_area_name")		String	_area_name
			,@Param("_event_name")		String	_event_name
			);
}
