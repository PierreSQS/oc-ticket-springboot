package org.example.demo.springboot;


import lombok.extern.slf4j.Slf4j;
import org.example.demo.springboot.business.factory.contract.ManagerFactory;
import org.example.demo.springboot.model.bean.ticket.TicketStatut;
import org.example.demo.springboot.model.exception.TechnicalException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Classe Principale de lancement des Batches.
 *
 * @author Pierrot Mongonnam
 */
@Slf4j
@SpringBootApplication
@ImportResource(locations = "classpath:org/example/demo/springboot/batch/batchContext.xml")
public class TicketSpringBootBatchApplication {

    /**
     * The entry point of application.
     *
     * @param pArgs the input arguments
     */
    public static void main(String[] pArgs) {
        
    	ConfigurableApplicationContext appCtx = 
        		new AnnotationConfigApplicationContext("org.example.demo.springboot");

        try (appCtx) {
            ManagerFactory vMgrFct = appCtx.getBean("managerFactory", ManagerFactory.class);
            FileSystemResource vRes = appCtx.getBean("resourceTicket", FileSystemResource.class);
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }

            String vTraitementId = pArgs[0];

            if ("ExportTicketStatus".equals(vTraitementId)) {

                log.info("Execution du traitement : ExportTicketStatus");

                // le module batch ne parle qu'avec le module business donc pas
                // d'appel direct d'un DAO !!!
                List<String> statuts = vMgrFct.getTicketManager().getListTicketStatut()
                        .stream()
                        .map(TicketStatut::toString)
                        .collect(Collectors.toList());

                writeStatut(vRes, statuts);

                log.info("###### Nom du fichier: " + vRes.getFilename());


                int beansCnt = appCtx.getBeanDefinitionCount();
                log.info("Number of Beans: " + beansCnt);

                log.info("The created Beans... ");
                Arrays.asList(appCtx.getBeanDefinitionNames())
                        .forEach(log::info);

            } else {
                throw new TechnicalException("Traitement inconnu : " + vTraitementId);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            System.exit(1);
        }
    }

	private static void writeStatut(Resource vRes, List<String> lines) throws IOException {
//		Files.write(Paths.get(vRes.getFilename()).toAbsolutePath(), lines, StandardCharsets.UTF_8);
		Files.write(Paths.get(vRes.getURI()), lines, StandardCharsets.UTF_8);
		log.info("###### URI: "+vRes.getURI().toString());
		log.info("###### File-Path: "+Paths.get(Objects.requireNonNull(vRes.getFilename())).toAbsolutePath().toString());
	}    
    
}
