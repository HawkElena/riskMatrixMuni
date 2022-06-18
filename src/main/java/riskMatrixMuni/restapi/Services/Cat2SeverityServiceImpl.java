package riskMatrixMuni.restapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.Cat2Severity;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Repositories.Cat2SeverityRepository;

@Service
public class Cat2SeverityServiceImpl implements Cat2SeverityService {

	@Autowired
	Cat2SeverityRepository entityRepository;
	
	@Override
	public List<Cat2Severity> buscarxnombre(String name, long muni_id) {
		return entityRepository.buscarxnombre(name, muni_id);
	}

	@Override
	public Cat2Severity save(Cat2Severity pEntity) {
		return  entityRepository.save(pEntity);
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
