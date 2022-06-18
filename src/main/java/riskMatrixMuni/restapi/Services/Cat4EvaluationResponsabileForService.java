package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Map;

import riskMatrixMuni.restapi.Models.Cat4EvaluateResponsabilefor;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat4EvaluationResponsabileForService {

//	Cat4EvaluateResponsabilefor save(Cat4EvaluateResponsabilefor pEntity);
	boolean deleteById(CompositeKeyFirst keyEvaluateResposabileFor);
	List<Map<String, ?>> ListarPositionAndMatrix( Cat4EvaluateResponsabilefor pEntityDTO );
	public Cat4EvaluateResponsabilefor save(Cat4EvaluateResponsabilefor pEntity);
}
