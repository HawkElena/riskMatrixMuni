package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1MatureCriteria;

public interface Cat1MatureCriteriaService {

	
	public Optional<Cat1MatureCriteria> findByName(String name);
	
	public List<Cat1MatureCriteria> findByNameContaining(String name);
	public List<Cat1MatureCriteria> findByNameIsContaining(String name);
	public List<Cat1MatureCriteria> findByNameLike(String name);
		
	List<Cat1MatureCriteria> buscarxnombre(String name, long muni_id);

	Cat1MatureCriteria save(Cat1MatureCriteria pMatureCriteria);

	boolean deleteById(CompositeKeyFirst keyPosition);
}
