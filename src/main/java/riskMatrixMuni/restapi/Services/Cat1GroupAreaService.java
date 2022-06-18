package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1GroupArea;

public interface Cat1GroupAreaService {

	public Optional<Cat1GroupArea> findByName(String name);
	
	public List<Cat1GroupArea> findByNameContaining(String name);
	public List<Cat1GroupArea> findByNameIsContaining(String name);
	public List<Cat1GroupArea> findByNameLike(String name);
		
	List<Cat1GroupArea> buscarxnombre(String name, long muni_id);

	Cat1GroupArea save(Cat1GroupArea pGroupArea);

	boolean deleteById(CompositeKeyFirst keyGroupArea);
	
}
