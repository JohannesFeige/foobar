package de.aclue.graphqltraining.superheroes.services;

import de.aclue.graphqltraining.superheroes.entities.Superhero;
import de.aclue.graphqltraining.superheroes.entities.SuperheroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuperheroServiceImpl implements SuperheroService {

    private final SuperheroRepository superHeroRepository;
    public long countPersistentHeros(){
        return superHeroRepository.count();
    }

    public void createHero(Superhero superHero) {
        superHero.updateDescription();
        if (superHeroRepository.findByApiIdAndPublisher(
                superHero.getApiId(), superHero.getPublisher()) == null) {
            superHeroRepository.save(superHero);
        }
    }

    @Override
    public List<Superhero> findAll() {
        return superHeroRepository.findAllByDescriptionIsNotNull();
    }

    @Override
    public Page<Superhero> findAll(int page, int size) {
        return superHeroRepository.findAllByDescriptionIsNotNull(PageRequest.of(page,size));
    }

    @Override
    public Superhero findById(Long favoritSuperheroId) {
        return superHeroRepository.findById(favoritSuperheroId).orElseThrow();
    }

}
