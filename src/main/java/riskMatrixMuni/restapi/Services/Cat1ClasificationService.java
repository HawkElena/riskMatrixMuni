package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import riskMatrixMuni.restapi.Models.Cat1Clasification;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat1ClasificationService {

	public Optional<Cat1Clasification> findByName(String name);
	
	public List<Cat1Clasification> findByNameContaining(String name);
	public List<Cat1Clasification> findByNameIsContaining(String name);
	public List<Cat1Clasification> findByNameLike(String name);
		
	List<Cat1Clasification> buscarxnombre(String name, long muni_id);

	Cat1Clasification save(Cat1Clasification pCat1Clasification);

	boolean deleteById(CompositeKeyFirst keyClasification);
}
