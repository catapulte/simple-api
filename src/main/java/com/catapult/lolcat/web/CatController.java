package com.catapult.lolcat.web;

import com.catapult.lolcat.model.Cat;
import com.catapult.lolcat.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by erwann on 16/01/17.
 */
@RestController
@CrossOrigin
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatRepository catRepository;

    @GetMapping
    public List<Cat> getAllCat(@RequestParam double lat,@RequestParam double lng, @RequestParam long distance) {

        Point point = new Point(lat, lng);
        Distance distance1 = new Distance(distance, Metrics.KILOMETERS);

        Circle circle = new Circle(point,distance1);

        return catRepository.findByPositionWithin(circle);
    }

    @GetMapping("/{id}")
    public Cat getCat(@PathVariable String id) {
        return catRepository.findOne(id);
    }

    @PostMapping
    public void postCat(@RequestBody Cat cat) {
        catRepository.save(cat);
    }


}
