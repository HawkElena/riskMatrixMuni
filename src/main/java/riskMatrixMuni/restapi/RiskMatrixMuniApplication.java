package riskMatrixMuni.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // para que se incluya la seguridad.
@ServletComponentScan
public class RiskMatrixMuniApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskMatrixMuniApplication.class, args);
		//prueba hawk subido al git
		System.out.println("add to git...");
	}

}
