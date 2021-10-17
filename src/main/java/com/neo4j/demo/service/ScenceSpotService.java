package com.neo4j.demo.service;

import com.neo4j.demo.entity.ScenceName;
import com.neo4j.demo.repository.ScenceSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScenceSpotService<T> {

//    @Resource
    @Autowired
    private ScenceSpot repository;

    public List<ScenceName> findScenceSpot() {
        return repository.findScenceSpot();
    }

    public List<ScenceName> findScenceSpot(int limit) {
        return repository.findLimitScenceSpots(limit);
    }


    public List<ScenceName> findRelatedScenceSpots(String province) {
        return repository.findRelatedScenceSpotsById(province);
    }

    public List<ScenceName> findScenceSpotByName(String name) {

        return repository.findScenceSpotByName(name);
    }

    public ScenceName saveScenceDescription(String province, String description) {
        return repository.saveScenceDescription(province, description);
    }


}
