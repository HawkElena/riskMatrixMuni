package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import riskMatrixMuni.restapi.Models.Cat3Event;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Repositories.Cat3EventRepository;

@Service
public class Cat3EventServiceImpl implements Cat3EventService {

	@Autowired
	Cat3EventRepository entityRepository;

	@Override
	public List<Cat3Event> buscarxnombre(String name, long muni_id) {
		return entityRepository.buscarxnombre(name, muni_id);
	}

	@Override
	public Cat3Event save(Cat3Event pEntity) {
		return  entityRepository.save(pEntity);
	}

	@Override
	public boolean deleteById(CompositeKeyFirst keyCompositeFirst) {
		boolean blnDeleted = false;
		try {
			entityRepository.deleteById(keyCompositeFirst);
			blnDeleted = true;
		} catch (Exception e) {
			blnDeleted = false;
		}
		return blnDeleted;
	}

	@Override
	public List<Cat3Event> buscarxAreaId(long evaluate_id, long muni_id) {
		return entityRepository.buscarxAreaEvaluate(evaluate_id, muni_id);
	}

	@Override
	public long max(long muni_id) {
		return entityRepository.max(muni_id);
		
	}

	@Override
	public List<Map<String, ?>> procListarEvent(long _muni_id, long _group_id, long _evaluate_id, long _id,
			String _group_name, String _area_name, String _event_name) {
		
		return entityRepository.procListarEvent(_muni_id, _group_id, _evaluate_id, _id, _group_name, _area_name, _event_name);

	}
	
	

}
