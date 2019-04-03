package es.fpdual.primero.eadmin;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;




@SpringBootApplication
public class EadminApplication {

	private static final Logger logger = LogManager.getLogger(EadminApplication.class);
	
	public static void main(String[] args) {
		logger.info("Iniciando servicio...");
		ConfigurableApplicationContext ejemplo = SpringApplication.run(EadminApplication.class, args);
		
		//ejemplo.close();
		//logger.info("Servicio finalizado");
	}
	
}
