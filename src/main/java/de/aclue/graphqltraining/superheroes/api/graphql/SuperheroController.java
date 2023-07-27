package de.aclue.graphqltraining.superheroes.api.graphql;

import de.aclue.graphqltraining.superheroes.entities.Superhero;
import de.aclue.graphqltraining.superheroes.services.SuperheroService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SuperheroController {

    private final SuperheroService superheroService;

    @SchemaMapping(typeName = "Query", value = "allSuperheros")
    public List<Superhero> allSuperherosOtherMethodName(){
        return superheroService.findAll();
    }

    @QueryMapping
    public Page<Superhero> allSuperherosPaged(@Argument int page, @Argument int size){
        return superheroService.findAll(page, size);
    }

}
