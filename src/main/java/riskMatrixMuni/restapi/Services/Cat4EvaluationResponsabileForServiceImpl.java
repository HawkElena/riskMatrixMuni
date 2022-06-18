package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.Cat4EvaluateResponsabilefor;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Repositories.Cat4EvaluateResponsabileForRepository;

@Service
public class Cat4EvaluationResponsabileForServiceImpl implements Cat4EvaluationResponsabileForService {

	@Autowired
	Cat4EvaluateResponsabileForRepository entityRepository;
	
	@Override
	public Cat4EvaluateResponsabilefor save(Cat4EvaluateResponsabilefor pEntity) {
		
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
	public List<Map<String, ?>> ListarPositionAndMatrix(Cat4EvaluateResponsabilefor pCatEvaluateResponsible) {
		return entityRepository.procListarPosition( 
				pCatEvaluateResponsible.getMuni_id()
				, pCatEvaluateResponsible.getResp_position_id()
				, pCatEvaluateResponsible.getEvaluation_plan_id()
				);

	}

}
