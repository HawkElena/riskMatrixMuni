package riskMatrixMuni.restapi.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import riskMatrixMuni.restapi.Models.Cat4EvaluateMatrix;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Request.Cat4EvaluateMatrixRequestDTO;
//import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Services.Cat4EvaluateMatrixService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/ListarEvaluationMatrix")
public class cat4EvaluateMatrixController {

	@Autowired
	Cat4EvaluateMatrixService entityService;
	
	@PostMapping("/listarEvaluationMatrix")
	@Transactional
	List<Map<String, ?>> getEvaluationMatrix(@RequestBody Cat4EvaluateMatrixRequestDTO pEntity){
		List<Map<String, ?>> lstEntityRet = new ArrayList<Map<String,?>>();
			if(pEntity.get_group_name()== "") {
				pEntity.set_group_name(null);
			}
			if(pEntity.get_area_name()== "") {
				pEntity.set_area_name(null);
			}
			if(pEntity.get_event_desc()== "") {
				pEntity.set_event_desc(null);
			}
		
			List<Map<String, ?>> lstEntityB =  entityService.ListarEvaluateMatrix(
					pEntity 
					);

			lstEntityRet = lstEntityB;
		
		return lstEntityRet;
	}


	@PostMapping("/EvaluationMatrixDML")
	@Transactional
	List< Cat4EvaluateMatrix> operacionDML(@RequestBody Cat4EvaluateMatrix pEntity) {
		List<Cat4EvaluateMatrix> lstEntityRet = new  ArrayList<Cat4EvaluateMatrix>();
		Cat4EvaluateMatrix entityInterno = new Cat4EvaluateMatrix();
		
		if(pEntity.get_opcionDML() == 1 || pEntity.get_opcionDML() == 3) {
			long maxTemCat4;
			if(pEntity.get_opcionDML() == 1) {
				maxTemCat4 = entityService.max(pEntity.getMuni_id());
				pEntity.setId(maxTemCat4);
				entityInterno.set_message("the register updated successfully...");			
				
			}else {
				entityInterno.set_message("the register inserted successfully...");			
				
			}
			
			entityInterno = entityService.save(pEntity);
			entityInterno.set_message("the operation was successfully...");
			entityInterno.set_opcionDML(pEntity.get_opcionDML());
			lstEntityRet.add(entityInterno);
		}else if(pEntity.get_opcionDML() == 2) {
			CompositeKeyFirst pk1 = new CompositeKeyFirst();
			pk1.setMuni_id(pEntity.getMuni_id());
			pk1.setId(pEntity.getId());
			
			entityInterno.setMuni_id(pk1.getMuni_id());
			entityInterno.setId(pk1.getId());
			
			if(entityService.deleteById(pk1)) {
				entityInterno.set_message("the register was deleted successfully..." + pk1);
				entityInterno.set_opcionDML(pEntity.get_opcionDML());
			}else {
				entityInterno.set_message("something was wrong chek all parameters..." + pk1);
				entityInterno.set_opcionDML(pEntity.get_opcionDML());
			}
			
			lstEntityRet.add(entityInterno);
		}
		
		return lstEntityRet;
	}
	
}
