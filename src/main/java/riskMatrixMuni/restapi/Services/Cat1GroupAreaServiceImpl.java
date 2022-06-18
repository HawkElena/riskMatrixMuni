package riskMatrixMuni.restapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1GroupArea;
import riskMatrixMuni.restapi.Repositories.Cat1GroupAreaRepository;

@Service
public class Cat1GroupAreaServiceImpl implements Cat1GroupAreaService {

	@Autowired
	Cat1GroupAreaRepository entityRepository;
	
	@Override
	public Optional<Cat1GroupArea>  findByName(String name) {
		Cat1GroupArea rsFBN = new Cat1GroupArea();
		rsFBN = entityRepository.findByName(name).get();
		return Optional.ofNullable(rsFBN);
	}

	@Override
	public List<Cat1GroupArea> findByNameContaining(String name) {
		
		return entityRepository.findByNameContaining(name);
	}

	@Override
	public List<Cat1GroupArea> findByNameIsContaining(String name) {
		return entityRepository.findByNameIsContaining(name);
	}

	@Override
	public List<Cat1GroupArea> findByNameLike(String name) {

		return entityRepository.findByNameLike(name);
	}

	@Override
	public List<Cat1GroupArea> buscarxnombre(String name, long muni_id) {
		return entityRepository.buscarxnombre(name, muni_id);
	}

	@Override
	public Cat1GroupArea save(Cat1GroupArea pEntity) {
		return entityRepository.save(pEntity);
	}
	
	@Override
	public boolean deleteById(CompositeKeyFirst keyCompositeFirst) {
		boolean blnDeleted= false;
		try {
			entityRepository.deleteById(keyCompositeFirst);
			blnDeleted = true;
		} catch (Exception e) {
			blnDeleted = false;
		}
		return blnDeleted;  
	}
	
}
