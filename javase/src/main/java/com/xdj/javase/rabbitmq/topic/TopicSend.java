package com.xdj.javase.rabbitmq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by xdj on 2017/5/21.
 */
public class TopicSend {
    private final static String EXCHANGE_NAME = "topic_logs";
    private final static String[] routingKeys = new String[]{
            "quick.orange.rabbit",
            "lazy.orange.elephant",
            "quick.orange.fox",
            "lazy.brown.fox",
            "quick.brown.fox",
            "quick.orange.male.rabbit",
            "lazy.orange.male.rabbit"};

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        for (String severity : routingKeys) {
            String message = "From " + severity + " routingKey' s message!";
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
        }

        channel.close();
        connection.close();
    }
}
