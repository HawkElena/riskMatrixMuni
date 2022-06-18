package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1Position;
import riskMatrixMuni.restapi.Repositories.Cat1PositionRepository;

@Service
public class Cat1PositionServiceImp implements Cat1PositionService {

	@Autowired
	Cat1PositionRepository entityRepository;
	
	@Override
	public Optional<Cat1Position> findByName(String name) {

		Cat1Position rsFBN = new Cat1Position();
		rsFBN = entityRepository.findByName(name).get();
		return Optional.ofNullable(rsFBN);
	}

	@Override
	public List<Cat1Position> findByNameContaining(String name) {
		return entityRepository.findByNameContaining(name);
	}

	@Override
	public List<Cat1Position> findByNameIsContaining(String name) {
		return entityRepository.findByNameIsContaining(name);
	}

	@Override
	public List<Cat1Position> findByNameLike(String name) {
		return entityRepository.findByNameLike(name);
	}

	@Override
	public List<Cat1Position> buscarxnombre(String name, long muni_id) {
		return entityRepository.buscarxnombre(name, muni_id);
	}

	@Override
	public Cat1Position save(Cat1Position pEntity) {

		return entityRepository.save(pEntity);
	}

	@Override
	public boolean deleteById(CompositeKeyFirst keyCompositeFirst) {
		boolean blnDeleted = false;
		try {
			entityRepository.deleteById(keyCompositeFirst);
			blnDeleted = true;
		} catch (Exception e) {
			blnDeleted = false;
		}
		return blnDeleted;
	}


}
