package riskMatrixMuni.restapi.Services;

import java.util.List;

import riskMatrixMuni.restapi.Models.Cat3Event;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat3EventService {

	List<Cat3Event> buscarxnombre(String name, long muni_id);
	
	List<Cat3Event> buscarxAreaId(long evaluate_id, long muni_id);
	
	Cat3Event save(Cat3Event pEntity);

	boolean deleteById(CompositeKeyFirst keyClasification);
}
