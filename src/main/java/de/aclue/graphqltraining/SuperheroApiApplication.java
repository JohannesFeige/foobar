package de.aclue.graphqltraining;

import de.aclue.graphqltraining.dataImport.services.MarvelImporterService;
import de.aclue.graphqltraining.fanInfo.services.FanInfoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
@ConfigurationPropertiesScan
@AllArgsConstructor
public class SuperheroApiApplication {

	private final FanInfoService fanInfoService;
	private final MarvelImporterService marvelImporterService;


	public static void main(String[] args) {
		SpringApplication.run(SuperheroApiApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void setupData(){
		fanInfoService.dataSetup();
		try {
			marvelImporterService.importDataFromCsv();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
