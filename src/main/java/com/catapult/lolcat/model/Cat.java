package com.catapult.lolcat.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Cat {

    @Id
    private String id;

    private double[] position;

    private long timestamp;

    private double vbat;


}
