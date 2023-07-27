package de.aclue.graphqltraining.fanInfo.services;

import de.aclue.graphqltraining.superheroes.services.SuperheroService;
import de.aclue.graphqltraining.fanInfo.entities.FanInfo;
import de.aclue.graphqltraining.fanInfo.entities.FanInfoRepository;
import de.aclue.graphqltraining.fanInfo.exceptions.FanInfoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FanInfoServiceImpl implements FanInfoService {

    private final FanInfoRepository fanInfoRepository;
    private final SuperheroService superheroService;

    @Override
    public void dataSetup() {
        this.createFan("Harley Keener");
    }

    @Override
    public FanInfo createFan(String name) {
        if (fanInfoRepository.count() <= 0){
            var newFanInfo = FanInfo.builder()
                    .name(name)
                    .build();
            return fanInfoRepository.save(newFanInfo);
        } else {
            return fanInfoRepository.findAll().get(0);
        }

    }

    @Override
    public FanInfo updateFanName(String name) {
        var one = fanInfoRepository.findAll().get(0);
        one.setName(name);
        return fanInfoRepository.save(one);
    }

    @Override
    public FanInfo addFavoritSuperhero(Long fanInfoId, Long superheroId) {
        Optional<FanInfo> fanInfoOptional = fanInfoRepository.findById(fanInfoId);
        FanInfo fanInfo = fanInfoOptional.orElseThrow(() -> new FanInfoNotFoundException(fanInfoId));
        fanInfo.setFavoritSuperhero(superheroService.findById(superheroId));
        return fanInfoRepository.save(fanInfo);
    }

    @Override
    public FanInfo getFanInfo() {
        return fanInfoRepository.findAll().size() == 0 ? null : fanInfoRepository.findAll().get(0);
    }
}
