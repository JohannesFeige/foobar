package de.aclue.graphqltraining.superheroes.entities;

import de.aclue.graphqltraining.superheroes.values.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperheroRepository extends JpaRepository<Superhero,Long> {

    Superhero findByApiIdAndPublisher(String apiId, Publisher publisher);

    List<Superhero> findAllByDescriptionIsNotNull();
    Page<Superhero> findAllByDescriptionIsNotNull(Pageable pageable);
}
