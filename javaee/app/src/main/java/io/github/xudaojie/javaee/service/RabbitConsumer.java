package io.github.xudaojie.javaee.service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xdj on 2017/5/22.
 */
public class RabbitConsumer {

    public void cunsumer(Object msg) {
        System.out.println("consumer :" + msg);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    }
}
