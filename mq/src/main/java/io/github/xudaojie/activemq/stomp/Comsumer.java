package io.github.xudaojie.activemq.stomp;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Comsumer {
    public static void main(String[] args) throws JMSException {
        StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
        factory.setBrokerURI("tcp://localhost:61613");
        Connection connection = factory.createConnection("admin", "password");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination des = new StompJmsDestination("stompQueue");
        MessageConsumer consumer = session.createConsumer(des);

        System.out.println("wait listening...");

        while (true) {
            Message msg = consumer.receive();
//            int id = msg.getIntProperty("id");
            String body = ((TextMessage)msg).getText();
            System.out.println(body);
            if ("SHUTDOWN".equals(body)) {
                break;
            }
        }

        connection.close();
    }
}
