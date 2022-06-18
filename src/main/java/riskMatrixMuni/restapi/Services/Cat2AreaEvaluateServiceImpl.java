package riskMatrixMuni.restapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riskMatrixMuni.restapi.Models.Cat2AreaEvaluate;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Repositories.Cat2AreaEvaluateRepository;

@Service
public class Cat2AreaEvaluateServiceImpl implements Cat2AreaEvaluateService {

	@Autowired
	Cat2AreaEvaluateRepository  entityRepository;

	@Override
	public List<Cat2AreaEvaluate> buscarxnombre(String name, long muni_id) {
		// TODO Auto-generated method stub
		return entityRepository.buscarxnombre(name, muni_id) ;
	}

	@Override
	public Cat2AreaEvaluate save(Cat2AreaEvaluate pEntity) {

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

	@Override
	public List<Cat2AreaEvaluate> buscarxGroupId(long group_area_id, long muni_id) {
		// TODO Auto-generated method stub
		return entityRepository.buscarxGropuId(group_area_id, muni_id) ;
	}


//	@Override
//	public List<Cat2AreaEvaluate> buscarxGroupId(long group_area_id, long muni_id) {
//		return entityRepository.buscarxGropuId(group_area_id, muni_id) ;
//	}

	

}
