package riskMatrixMuni.restapi.Repositories;

import java.util.List;

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
		
}
