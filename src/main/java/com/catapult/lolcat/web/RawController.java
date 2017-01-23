package com.catapult.lolcat.web;

import com.catapult.lolcat.service.RawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/location")
public class RawController {

    @Autowired
    private RawService rawService;

    @GetMapping
    public void consume(@RequestParam("rawdata") String rawData) throws ParseException {
        rawService.processRawData(rawData);
    }


}
