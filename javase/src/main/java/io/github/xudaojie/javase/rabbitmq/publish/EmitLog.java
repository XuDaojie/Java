package io.github.xudaojie.javase.rabbitmq.publish;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by xdj on 2017/5/21.
 */
public class EmitLog {
    private final static String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,  BuiltinExchangeType.FANOUT);
        for (int i = 0; i < 5; i++) {
            String message = "Hello World!" + i;
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }

        channel.close();
        connection.close();
    }
}
