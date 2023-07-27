package de.aclue.graphqltraining.fanInfo.services;

import de.aclue.graphqltraining.fanInfo.entities.FanInfo;

public interface FanInfoService {

    void dataSetup();

    FanInfo createFan(String name);
    FanInfo updateFanName(String name);

    FanInfo addFavoritSuperhero(Long userInfoId, Long superheroId);

    FanInfo getFanInfo();
}
