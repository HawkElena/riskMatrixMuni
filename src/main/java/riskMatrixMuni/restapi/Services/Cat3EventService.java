package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Map;

import riskMatrixMuni.restapi.Models.Cat3Event;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat3EventService {

	List<Cat3Event> buscarxnombre(String name, long muni_id);
	
	List<Cat3Event> buscarxAreaId(long evaluate_id, long muni_id);
	
	Cat3Event save(Cat3Event pEntity);

	boolean deleteById(CompositeKeyFirst keyClasification);
	
	public long max(long muni_id);
	
	List<Map<String, ?>>  procListarEvent (
			long	_muni_id
			,long	_group_id
			,long	_evaluate_id
			,long	_id
			,String	_group_name
			,String	_area_name
			,String	_event_name);
}
