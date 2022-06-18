package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1Position;

public interface Cat1PositionService {

	
	public Optional<Cat1Position> findByName(String name);
	
	public List<Cat1Position> findByNameContaining(String name);
	public List<Cat1Position> findByNameIsContaining(String name);
	public List<Cat1Position> findByNameLike(String name);
		
	List<Cat1Position> buscarxnombre(String name, long muni_id);

	Cat1Position save(Cat1Position pPosition);

	boolean deleteById(CompositeKeyFirst keyPosition);
}
