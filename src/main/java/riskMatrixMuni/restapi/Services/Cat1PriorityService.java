package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1Priority;

public interface Cat1PriorityService {

	public Optional<Cat1Priority> findByName(String name);
	
	public List<Cat1Priority> findByNameContaining(String name);
	public List<Cat1Priority> findByNameIsContaining(String name);
	public List<Cat1Priority> findByNameLike(String name);
		
	List<Cat1Priority> buscarxnombre(String name, long muni_id,int tabla_id);

	Cat1Priority save(Cat1Priority pPriority);

	boolean deleteById(CompositeKeyFirst keyPosition);
}
