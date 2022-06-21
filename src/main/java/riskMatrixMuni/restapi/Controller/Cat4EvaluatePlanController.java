package riskMatrixMuni.restapi.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import riskMatrixMuni.restapi.Models.Cat4EvaluatePlan;
import riskMatrixMuni.restapi.Models.Cat4EvaluateResponsabilefor;
import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Request.Cat4EvaluatePlanRequestDTO;
import riskMatrixMuni.restapi.Services.Cat4EvaluatePlanService;
import riskMatrixMuni.restapi.Services.Cat4EvaluationResponsabileForService;





@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/ListarEvaluationPlan")
public class Cat4EvaluatePlanController {
	
	@Autowired
	Cat4EvaluatePlanService entityService;
	
	@Autowired
	Cat4EvaluationResponsabileForService entityPositionsService;
	
	@PostMapping("/listarEvaluationPlan")
	@Transactional
	List<Map<String, ?>> getEvaluationPlan(@RequestBody Cat4EvaluatePlanRequestDTO pEntity){
		List<Map<String, ?>> lstEntityRet = new ArrayList<Map<String,?>>();
//		List<Map<Cat4EvaluatePlanRequestDTO,?>> responsePlan = new ArrayList<Map<Cat4EvaluatePlanRequestDTO,?>>();
		
		
			if(pEntity.get_startDate()== "") {
				pEntity.set_startDate(null);
			}
			if(pEntity.get_endDate()== "") {
				pEntity.set_endDate(null);
			}
			if(pEntity.get_controlRecomend()== "") {
				pEntity.set_controlRecomend(null);
			}
			if(pEntity.get_riesgo()== "") {
				pEntity.set_riesgo(null);
			}
			if(pEntity.get_priority_name()== "") {
				pEntity.set_priority_name(null);
			}
		
			
			List<Map<String, ?>> lstEntityB =  entityService.ListarEvaluatePlan(
					pEntity 
					);
			
			List<Cat4EvaluatePlan> lstxxx = new ArrayList<Cat4EvaluatePlan>();
			Cat4EvaluatePlan lstyyy = new Cat4EvaluatePlan();
			Cat4EvaluateResponsabilefor postion = new Cat4EvaluateResponsabilefor();
			
			
			
			postion.setMuni_id(1);
			postion.setResp_position_id(2);
			postion.setEvaluation_plan_id(1);
			postion.set_position_name("hawkBoss");
			
			
			for (Map<String, ?> element: lstEntityB) {
				
				int 	tmpMunis 				=	(Integer)	element.get("muni_id");
				int 	tmpMatrix 				= 	(Integer) 	element.get("matrix_id");
				int 	tmpId 					= 	(Integer) 	element.get("id");
				String 	tmpRecomendations 		= 	(String) 	element.get("recomendations");
				String 	tmpImplement_control 	= 	(String) 	element.get("implement_control");
				int 	tmpPriority_id 			= 	(Integer) 	element.get("priority_id");
		
////				String 	tmpStartdate 			= 	(String) 	element.get("startdate");
////				String 	tmpEnddate 				= 	(String) 	element.get("enddate");

////				java.util.Date tmpStartDate		= new java.util.Date();
////				java.sql.Date sqlPack			= new java.sql.Date(tmpStartDate.getTime());
////				java.util.Date tmpEndate		= new java.util.Date();
////				java.sql.Date sqlPack2			= new java.sql.Date(tmpEndate.getTime());

				String 	tmpRemarks 				= 	(String) 	element.get("remarks");
				int 	tmpMatrix_id 			= 	(Integer) 	element.get("matrix_id");
				String 	tmp_matrix_riesgo 		= 	(String) 	element.get("_matrix_riesgo");
				String  tmp_matrix				= 	(String)	element.get("tmp_matrix");
				String 	tmp_riesgo_residual		= 	(String)	element.get("_riesgo_residual").toString();
//				String 	tmpPriorityName 	= 	(String) 	element.get("_priority_name");
				
				
//				
//				System.out.println("the value date =" + tmpStartdate);
				
				lstyyy.setMuni_id(Long.valueOf(tmpMunis));
				lstyyy.setMatrix_id((Long.valueOf(tmpMatrix)));				
				lstyyy.setId(Long.valueOf(tmpId));
				lstyyy.setRecomendations(tmpRecomendations);
				lstyyy.setImplement_control(tmpImplement_control);
				lstyyy.setPriority_id(Long.valueOf(tmpPriority_id));
				
//				lstyyy.setStartdate((String) 	element.get("startdate"));
//				lstyyy.setEnddate((String) 	element.get("enddate"));
//				lstyyy.setStartdate((String) sqlPack.toString());
//				lstyyy.setEnddate((String) sqlPack2.toString());
				
				lstyyy.setRemarks(tmpRemarks);
				lstyyy.setMatrix_id( Long.valueOf(tmpMatrix_id));
				lstyyy.set_priority_name((String)element.get("_priority_name"));
				lstyyy.set_matrix_riesgo(tmp_matrix_riesgo);
				lstyyy.set_matrix(tmp_matrix);
				lstyyy.set_riesgo_residual(tmp_riesgo_residual);
				
				
//				positions
				lstxxx.add(lstyyy);
				
			}
			
			
			lstEntityRet = lstEntityB;
		
		return lstEntityRet;
	}
	
	@PostMapping("/EvaluationPlanDML")
	@Transactional
	List< Cat4EvaluatePlan> operacionDML(@RequestBody Cat4EvaluatePlan pEntity) {
		List<Cat4EvaluatePlan> lstEntityRet = new  ArrayList<Cat4EvaluatePlan>();
		Cat4EvaluatePlan entityInterno = new Cat4EvaluatePlan();
		
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

			//aca hay que hacer el proceso de guardar los positions
			List<Long> PositionId = pEntity.getPositions().stream().map(position -> position.getResp_position_id()).collect(Collectors.toList());
			
			Long PlanId = entityInterno.getId();
			Cat4EvaluateResponsabilefor	pEntity2 = new Cat4EvaluateResponsabilefor();
			
			pEntity2.setMuni_id(pEntity.getMuni_id());
			pEntity2.setEvaluation_plan_id(PlanId);
			
			for (Long elemento : PositionId) {
				pEntity2.setResp_position_id(elemento);
				entityPositionsService.save(pEntity2);
			};


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
