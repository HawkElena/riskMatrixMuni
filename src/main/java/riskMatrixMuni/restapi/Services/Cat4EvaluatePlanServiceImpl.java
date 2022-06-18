package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.Cat4EvaluatePlan;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Repositories.Cat4EvaluatePlanRepository;
import riskMatrixMuni.restapi.Request.Cat4EvaluatePlanRequestDTO;

@Service
public class Cat4EvaluatePlanServiceImpl implements Cat4EvaluatePlanService {

	@Autowired
	Cat4EvaluatePlanRepository entityRepository;
	
	@Override
	public Cat4EvaluatePlan save(Cat4EvaluatePlan pEntity) {
		return entityRepository.save(pEntity);
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
	public List<Map<String, ?>> ListarEvaluatePlan(Cat4EvaluatePlanRequestDTO pEntityDTO) {
		return entityRepository.procListarEvaluatePlan( 
					pEntityDTO.get_muni_id()
				, 	pEntityDTO.get_startDate()
				, 	pEntityDTO.get_endDate()
				, 	pEntityDTO.get_controlRecomend()
				, 	pEntityDTO.get_riesgo()
				, 	pEntityDTO.get_matrixa_id()
				, 	pEntityDTO.get_priority_name()
				
				);

	}

	@Override
	public long max(long muni_id) {
		return entityRepository.max(muni_id);
		
	}
	

}
