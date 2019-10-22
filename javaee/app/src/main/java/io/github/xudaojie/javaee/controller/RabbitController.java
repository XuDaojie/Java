package io.github.xudaojie.javaee.controller;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xdj on 2017/5/22.
 */
@RestController
public class RabbitController {

    @Autowired
    private RabbitTemplate mRabbitTemplate;

    @RequestMapping("/rabbit/setmsg")
    public String setMessage(
            @RequestParam(value = "routing_key", defaultValue = "testQueue") String routingKey,
            @RequestParam(value = "msg", defaultValue = "Hello World!") String msg) {
        ConnectionFactory factory = mRabbitTemplate.getConnectionFactory();
        System.out.println(factory.getHost());
        System.out.println(factory.getPort());
        mRabbitTemplate.convertAndSend("testExchange", routingKey, msg);
        return "setMsg";
    }
}
