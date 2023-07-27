package de.aclue.graphqltraining.superheroes.services;

import de.aclue.graphqltraining.superheroes.entities.Superhero;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SuperheroService {
    long countPersistentHeros();
    void createHero(Superhero superHero);

    List<Superhero> findAll();
    Page<Superhero> findAll(int page, int size);

    Superhero findById(Long favoritSuperheroId);
}
