package de.aclue.graphqltraining.superheroes.api.graphql;

import de.aclue.graphqltraining.dataImport.services.MarvelImporterService;
import de.aclue.graphqltraining.fanInfo.services.FanInfoService;
import de.aclue.graphqltraining.superheroes.entities.Superhero;
import de.aclue.graphqltraining.superheroes.entities.SuperheroRepository;
import de.aclue.graphqltraining.superheroes.services.SuperheroServiceImpl;
import de.aclue.graphqltraining.superheroes.values.Publisher;
import graphql.com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

import static org.mockito.Mockito.when;

@Import({SuperheroServiceImpl.class})
@GraphQlTest(controllers = SuperheroController.class)
class SuperheroControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private SuperheroRepository superheroRepository;
    @MockBean
    private FanInfoService fanInfoService; // in main fuer testdaten
    @MockBean
    private MarvelImporterService marvelImporterService; // in main fuer testdaten
    @Test
    public void shouldReturnSuperheroUnpaged() {
        setupMockData();
        // language=GraphQl
        String document = """
                      query {
                      allSuperheros {
                        id,
                        name,
                        description              
                      }
                      } 
                """;
        GraphQlTester.Response response = graphQlTester.document(document)
                .execute();
        response
                .path("allSuperheros")
                .entityList(Superhero.class)
                .hasSize(5);
    }

    private List<Superhero> createSuperheroes() {
        var ironMan = createsuperhero(1L, "Iron Man", "Tony Stark is the wealthy son of industrialist and weapons " +
                "manufacturer Howard Stark and his wife, Maria.");
        var drStrange = createsuperhero(2L, "Doctor Strange", "A Master of the Mystic Arts.");
        var hulk = createsuperhero(3L, "Hulk", "");
        var thor = createsuperhero(4L, "Thor", "");
        var groot = createsuperhero(5L, "Groot", "");
        return Lists.newArrayList(ironMan, drStrange, hulk, thor, groot);

    }

    private Superhero createsuperhero(Long id, String name, String description) {
        return Superhero
                .builder()
                .id(id)
                .apiId(String.valueOf(id))
                .name(name)
                .description(description)
                .publisher(Publisher.MARVEL)
                .build();
    }

    private void setupMockData() {
        when(superheroRepository.findAllByDescriptionIsNotNull()).thenReturn(createSuperheroes());
    }
}