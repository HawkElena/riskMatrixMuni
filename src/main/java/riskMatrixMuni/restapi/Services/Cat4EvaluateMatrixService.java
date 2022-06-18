package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Map;

import riskMatrixMuni.restapi.Models.Cat4EvaluateMatrix;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Request.Cat4EvaluateMatrixRequestDTO;

public interface Cat4EvaluateMatrixService {

	Cat4EvaluateMatrix save(Cat4EvaluateMatrix pEntity);
	boolean deleteById(CompositeKeyFirst keyEvaluatematrix);
	List<Map<String, ?>> ListarEvaluateMatrix( Cat4EvaluateMatrixRequestDTO pEntityDTO );
	
	public long max(long muni_id);
	

	
}
