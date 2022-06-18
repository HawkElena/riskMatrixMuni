package riskMatrixMuni.restapi.Services;

import java.util.List;

import riskMatrixMuni.restapi.Models.Cat2Severity;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat2SeverityService {

	List<Cat2Severity> buscarxnombre(String name, long muni_id);

	Cat2Severity save(Cat2Severity pEntity);

	boolean deleteById(CompositeKeyFirst keyClasification);

}
