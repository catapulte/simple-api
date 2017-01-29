package com.catapult.lolcat.component;

import com.catapult.lolcat.service.RawService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqListener {

    @Autowired
    private RawService rawService;

    @RabbitListener(queues = "cat.data")
    public void process(Message<byte[]> data) {
        String message = new String(data.getPayload());
        rawService.processRawData(message);
    }
}
