package com.catapult.lolcat.component;

import com.catapult.lolcat.service.RawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    @Autowired
    private RawService rawService;

    public Receiver() {
        System.out.println();
    }

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(byte[] message) {

        String msg = new String(message);

        rawService.processRawData(msg);
        System.out.println("Received <" + msg + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}