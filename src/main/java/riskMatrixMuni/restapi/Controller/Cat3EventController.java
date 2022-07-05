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
			long maxTemCat4;
			if(pEntity.get_opcionDML()==1) {
				maxTemCat4 = entityService.max(pEntity.getMuni_id());
				pEntity.setId(maxTemCat4);				
				System.out.println("El max = " + pEntity.getId());
			}
			
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
		}else if(pEntity.get_opcionDML() == 6) {

//			Cat3Event itemTempEvent = new Cat3Event();
			
			List<Map<String, ?>> lstEntityB =  entityService.procListarEvent(
					pEntity.getMuni_id()
					,pEntity.get_group_id()
					,pEntity.getEvaluate_id()
					,pEntity.getId()
					,pEntity.get_group_name()
					,pEntity.get_area_name()
					,pEntity.get_area_name()
					);
			
			System.out.println("El numero de registros = " + lstEntityB.size());
			for (Map<String, ?> element: lstEntityB) {
				Cat3Event lstTempEvent = new Cat3Event();
				
				System.out.println("-----------------------------------------------------" );
				int 	tmpMunis 				=	(Integer)	element.get("event_muni_id");
				int 	tmpid 					=	(Integer)	element.get("event_id");
				String 	name					=	(String)	element.get("event_description");
				int 	tmpAreaId 				=	(Integer)	element.get("event_area_evaluate_id");
				String 	tmpGroupId 				=	String.valueOf(element.get("group_id"));
				String 	tmpGroupName			=	(String)	element.get("group_name");
				String 	tmpAreaName				=	(String)	element.get("area_name");
//				String 	tmpEventName			=	(String)	element.get("event_description");
				
				
				System.out.println("Entro en el for y la variable muni = " + tmpMunis);
				System.out.println("Entro en el for y la variable id = " + tmpid);
				System.out.println("Entro en el for y la variable nombreevento = " + name);
				System.out.println("Entro en el for y la variable areaid = " + tmpAreaId);
				System.out.println("Entro en el for y la variable groupId = " + tmpGroupId);
				System.out.println("Entro en el for y la variable GroupNmae = " + tmpGroupName);
				System.out.println("Entro en el for y la variable AreaName = " + tmpAreaName);
//				System.out.println("Entro en el for y la variable EventName = " + tmpEventName);
				
				lstTempEvent.setMuni_id(tmpMunis);
				lstTempEvent.setId(tmpid);
				lstTempEvent.setName(name);
				lstTempEvent.setEvaluate_id(tmpAreaId);
				lstTempEvent.set_group_id(Long.valueOf(tmpGroupId));
				lstTempEvent.set_group_name(tmpGroupName);
				lstTempEvent.set_area_name(tmpAreaName);
//				lstTempEvent.set_event_name(tmpEventName);
			
				lstEntityRet.add(lstTempEvent);
			}
			
			
		};
			
		
		//lstGroupArea.add(groupA);
		return lstEntityRet;
	}
}
