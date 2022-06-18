package riskMatrixMuni.restapi.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/test")
public class hawkTestController {

	@GetMapping("/hawktest")
	public String GetHello() {
		return "hawk is son of God! Thanks many thanks father day!";
	}
}
