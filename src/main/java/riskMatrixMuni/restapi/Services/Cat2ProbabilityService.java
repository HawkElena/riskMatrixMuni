package riskMatrixMuni.restapi.Services;

import java.util.List;

import riskMatrixMuni.restapi.Models.Cat2Probability;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat2ProbabilityService {
	List<Cat2Probability> buscarxnombre(String name, long muni_id);

	Cat2Probability save(Cat2Probability pCat2Probability);

	boolean deleteById(CompositeKeyFirst keyClasification);
}
