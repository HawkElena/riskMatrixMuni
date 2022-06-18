package riskMatrixMuni.restapi.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import riskMatrixMuni.restapi.Models.Cat3Event;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Services.Cat3EventService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/Event")

public class Cat3EventController {

	
	@Autowired
	Cat3EventService entityService;
	
	@PostMapping("/eventDML")
	@Transactional
	List<Cat3Event> getClasification(@RequestBody Cat3Event pEntity){
		List<Cat3Event> lstEntityRet = new ArrayList<Cat3Event>();
		Cat3Event entityInterno = new Cat3Event();
		
		if(pEntity.get_opcionDML()== 1 || pEntity.get_opcionDML() == 3 ) {

			entityInterno = entityService.save(pEntity);
			entityInterno.set_message("the register was inserted successfully...");			
			entityInterno.set_opcionDML(pEntity.get_opcionDML());
			lstEntityRet.add(entityInterno);
			
		}else if (pEntity.get_opcionDML()== 2){
			
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
		}else if(pEntity.get_opcionDML() == 4) {
			
			List<Cat3Event> lstEntityB =  entityService.buscarxnombre(
					pEntity.getName()
					,pEntity.getMuni_id()
					);

			lstEntityRet= lstEntityB;
		}else if(pEntity.get_opcionDML() == 5) {
			List<Cat3Event> lstEntityB =  entityService.buscarxAreaId(
					pEntity.getEvaluate_id()
					,pEntity.getMuni_id()
					);

			lstEntityRet= lstEntityB;
			
		};
			
		
		//lstGroupArea.add(groupA);
		return lstEntityRet;
	}
}
