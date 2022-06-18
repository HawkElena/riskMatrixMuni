package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.Cat1Clasification;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

import riskMatrixMuni.restapi.Repositories.Cat1ClasificationRepository;

@Service
public class Cat1ClasificationServiceImpl implements Cat1ClasificationService {

	@Autowired
	Cat1ClasificationRepository entityRepository;

	@Override
	public Optional<Cat1Clasification> findByName(String name) {

		Cat1Clasification rsFBN = new Cat1Clasification();
		rsFBN = entityRepository.findByName(name).get();
		return Optional.ofNullable(rsFBN);
	}

	@Override
	public List<Cat1Clasification> findByNameContaining(String name) {
		return entityRepository.findByNameContaining(name);
	}

	@Override
	public List<Cat1Clasification> findByNameIsContaining(String name) {
		return entityRepository.findByNameIsContaining(name);
	}

	@Override
	public List<Cat1Clasification> findByNameLike(String name) {
		return entityRepository.findByNameLike(name);
	}

	@Override
	public List<Cat1Clasification> buscarxnombre(String name, long muni_id) {
		return entityRepository.buscarxnombre(name, muni_id);
	}

	@Override
	public Cat1Clasification save(Cat1Clasification pEntity) {

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
