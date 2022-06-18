package riskMatrixMuni.restapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.Cat2RiskTolerance;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Repositories.Cat2RiskToleranceRepository;

@Service
public class Cat2RiskToleranceServiceImpl implements Cat2RiskToleranceService {

	@Autowired
	Cat2RiskToleranceRepository entityRepository;
	
	@Override
	public List<Cat2RiskTolerance> buscarxnombre(String name, long muni_id) {
		return entityRepository.buscarxnombre(name, muni_id);
	}

	@Override
	public Cat2RiskTolerance save(Cat2RiskTolerance pEntity) {
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
