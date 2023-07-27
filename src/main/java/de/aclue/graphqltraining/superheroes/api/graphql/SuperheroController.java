package de.aclue.graphqltraining.superheroes.api.graphql;

import de.aclue.graphqltraining.superheroes.services.SuperheroService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SuperheroController {

    private final SuperheroService superheroService;

    //TODO Aufgabe 1

}
