package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1MatureCriteria;
import riskMatrixMuni.restapi.Repositories.Cat1MatureCriteriaRepository;

@Service
public class Cat1MatureCriteriaServiceImpl implements Cat1MatureCriteriaService {

	@Autowired
	Cat1MatureCriteriaRepository entityRepository;
	
	@Override
	public Optional<Cat1MatureCriteria> findByName(String name) {

		Cat1MatureCriteria rsFBN = new Cat1MatureCriteria();
		rsFBN = entityRepository.findByName(name).get();
		return Optional.ofNullable(rsFBN);
	}

	@Override
	public List<Cat1MatureCriteria> findByNameContaining(String name) {
		return entityRepository.findByNameContaining(name);
	}

	@Override
	public List<Cat1MatureCriteria> findByNameIsContaining(String name) {
		return entityRepository.findByNameIsContaining(name);
	}

	@Override
	public List<Cat1MatureCriteria> findByNameLike(String name) {
		return entityRepository.findByNameLike(name);
	}

	@Override
	public List<Cat1MatureCriteria> buscarxnombre(String name, long muni_id) {
		return entityRepository.buscarxnombre(name, muni_id);
	}

	@Override
	public Cat1MatureCriteria save(Cat1MatureCriteria pEntity) {

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
