package riskMatrixMuni.restapi.Services;

import java.util.List;

import riskMatrixMuni.restapi.Models.Cat2RiskTolerance;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat2RiskToleranceService {

	List<Cat2RiskTolerance> buscarxnombre(String name, long muni_id);

	Cat2RiskTolerance save(Cat2RiskTolerance pEntity);

	boolean deleteById(CompositeKeyFirst keyClasification);
}
