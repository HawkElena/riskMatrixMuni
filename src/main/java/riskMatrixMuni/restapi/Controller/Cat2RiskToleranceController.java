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

import riskMatrixMuni.restapi.Models.Cat2RiskTolerance;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Services.Cat2RiskToleranceService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/RiskTolerance")

public class Cat2RiskToleranceController {

	@Autowired
	Cat2RiskToleranceService entityService;
	
	@PostMapping("/riskToleranceDML")
	@Transactional
	List<Cat2RiskTolerance> getClasification(@RequestBody Cat2RiskTolerance pEntity){
		List<Cat2RiskTolerance> lstEntityRet = new ArrayList<Cat2RiskTolerance>();
		Cat2RiskTolerance entityInterno = new Cat2RiskTolerance();
		
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
			
			List<Cat2RiskTolerance> lstEntityB =  entityService.buscarxnombre(
					pEntity.getDescription()
					,pEntity.getMuni_id()
					);

			lstEntityRet= lstEntityB;
		};
			
		
		//lstGroupArea.add(groupA);
		return lstEntityRet;
	}
}
