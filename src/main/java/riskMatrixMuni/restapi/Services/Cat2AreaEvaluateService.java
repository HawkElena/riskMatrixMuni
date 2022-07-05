package riskMatrixMuni.restapi.Services;

import java.util.List;

import riskMatrixMuni.restapi.Models.Cat2AreaEvaluate;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;

public interface Cat2AreaEvaluateService {

//	public Optional<Cat2AreaEvaluate> findByNameAndFk_id(String name, long fk_id);
	
//	public List<Cat2AreaEvaluate> findByNameAndArea_evaluate_group_area_idContaining(String name, long group_area_id);
//	public List<Cat2AreaEvaluate> findByNameAndGroup_area_idIsContaining(String name, long group_area_id);
//	public List<Cat2AreaEvaluate> findByNameAndGroup_area_idLike(String name, long group_area_id);
//		
	List<Cat2AreaEvaluate> buscarxnombre(String name, long muni_id);
	
	List<Cat2AreaEvaluate> buscarxGroupId(long group_area_id, long muni_id);
	
	Cat2AreaEvaluate save(Cat2AreaEvaluate pCat2AreaEvaluate);

	boolean deleteById(CompositeKeyFirst keyClasification);
	public long max(long muni_id);
}
