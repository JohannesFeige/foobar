package de.aclue.graphqltraining.dataImport.services;


import de.aclue.graphqltraining.superheroes.entities.Superhero;
import de.aclue.graphqltraining.superheroes.services.SuperheroService;
import de.aclue.graphqltraining.superheroes.values.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static de.aclue.graphqltraining.dataImport.config.CsvConfig.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class MarvelImporterService {

    private final SuperheroService superheroService;

    public void importDataFromCsv() throws IOException {
        if (superheroService.countPersistentHeros() <= 10){
            log.info("importDataFromCsv - started");
            try (Reader reader = Files.newBufferedReader(Paths.get(HEROES_CSV));
                 CSVParser csvParser = new CSVParser(reader, HERO_CSV_FORMAT)) {
                csvParser.stream().forEach(record -> {
                    var newHero = Superhero.builder()
                            .apiId(record.get(CSV_INDEX_API_ID))
                            .name(record.get(CSV_INDEX_NAME))
                            .description(record.get(CSV_INDEX_DESCRIPTION))
                            .thumbnailUrl(record.get(CSV_INDEX_THUMBNAIL_URL))
                            .publisher(Publisher.valueOf(record.get(CSV_INDEX_PUBLISHER)))
                            .build();
                    superheroService.createHero(newHero);
                });
            }
        }else {
            log.info("import skipped");
        }
    }

}
