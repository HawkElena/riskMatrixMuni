package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.Cat4EvaluateMatrix;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Repositories.Cat4EvaluateMatrixRepository;
import riskMatrixMuni.restapi.Request.Cat4EvaluateMatrixRequestDTO;

@Service
public class Cat4EvaluateMatrixServiceImpl implements Cat4EvaluateMatrixService {

	@Autowired
	Cat4EvaluateMatrixRepository	entityRepository;
	
	@Override
	public List<Map<String, ?>> ListarEvaluateMatrix(Cat4EvaluateMatrixRequestDTO  pCat4EvaluateMatrix) {
		
		return entityRepository.procListarEvaluateMatrix( pCat4EvaluateMatrix.get_muni_id()
															, pCat4EvaluateMatrix.get_event_ids()
															, pCat4EvaluateMatrix.get_prob_id()
															, pCat4EvaluateMatrix.get_sever_id()
															, pCat4EvaluateMatrix.get_event_desc()
															, pCat4EvaluateMatrix.get_area_name()
															, pCat4EvaluateMatrix.get_group_name()
															, pCat4EvaluateMatrix.get_prob_puntaje()
															, pCat4EvaluateMatrix.get_sever_puntaje()
															);
	}

	@Override
	public Cat4EvaluateMatrix save(Cat4EvaluateMatrix pEntity) {
		
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
	public long max(long muni_id) {
		return entityRepository.max(muni_id);
		
	}

}
