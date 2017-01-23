package com.catapult.lolcat.service;

import com.catapult.lolcat.model.Cat;
import com.catapult.lolcat.model.DecimalCoord;
import com.catapult.lolcat.repository.CatRepository;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RawService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RawService.class);

    private FastDateFormat dateFormat = FastDateFormat.getInstance("dd/MM/yyyy'@'HH:mm:ss.SSS");

    @Autowired
    private CatRepository catRepository;

    public void processRawData(String rawData) {

        try {
            String regexp = "#(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)#";

            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawData);

            if (matcher.matches()) {
                Cat cat = new Cat();

                String id = matcher.group(1);
                cat.setId(id);

                String lat = matcher.group(2);
                String lng = matcher.group(3);
                DecimalCoord decimalCoord = new DecimalCoord(lat, lng);
                cat.setPosition(decimalCoord.getDecimalCoord());

                String angle = matcher.group(4);
                String alt = matcher.group(5);
                String ts = matcher.group(6);

                Date parse = dateFormat.parse(ts);
                cat.setTimestamp(parse.getTime());

                double vbat = Double.valueOf(matcher.group(7));
                cat.setVbat(vbat);

                catRepository.save(cat);


            }
        } catch (Exception e) {
            LOGGER.error("too bad", e);
        }

    }


}
