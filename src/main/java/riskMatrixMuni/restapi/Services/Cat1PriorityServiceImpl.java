package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1Priority;
import riskMatrixMuni.restapi.Repositories.Cat1PriorityRepository;

@Service
public class Cat1PriorityServiceImpl implements Cat1PriorityService {

	@Autowired
	Cat1PriorityRepository entityRepository;
	
	@Override
	public Optional<Cat1Priority> findByName(String name) {

		Cat1Priority rsFBN = new Cat1Priority();
		rsFBN = entityRepository.findByName(name).get();
		return Optional.ofNullable(rsFBN);
	}

	@Override
	public List<Cat1Priority> findByNameContaining(String name) {
		return entityRepository.findByNameContaining(name);
	}

	@Override
	public List<Cat1Priority> findByNameIsContaining(String name) {
		return entityRepository.findByNameIsContaining(name);
	}

	@Override
	public List<Cat1Priority> findByNameLike(String name) {
		return entityRepository.findByNameLike(name);
	}

	@Override
	public List<Cat1Priority> buscarxnombre(String name, long muni_id,int tabla_id) {
		return entityRepository.buscarxnombre(name, muni_id,tabla_id);
	}

	@Override
	public Cat1Priority save(Cat1Priority pEntity) {

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
