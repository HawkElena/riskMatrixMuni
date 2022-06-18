package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Map;
import riskMatrixMuni.restapi.Models.Cat4EvaluatePlan;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Request.Cat4EvaluatePlanRequestDTO;

public interface Cat4EvaluatePlanService {

	Cat4EvaluatePlan save(Cat4EvaluatePlan pEntity);
	boolean deleteById(CompositeKeyFirst keyEvaluatematrix);
	List<Map<String, ?>> ListarEvaluatePlan( Cat4EvaluatePlanRequestDTO pEntityDTO );
	
	public long max(long muni_id);
}
