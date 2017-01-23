package com.catapult.lolcat.repository;

import com.catapult.lolcat.model.Cat;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CatRepository extends MongoRepository<Cat, String> {

    List<Cat> findByPositionWithin(Circle c);
}
