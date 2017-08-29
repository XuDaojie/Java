package com.mq.stomp;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Producter {
    public static void main(String[] args) throws JMSException {
        StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
        factory.setBrokerURI("tcp://localhost:61613");
        Connection connection = factory.createConnection("admin", "password");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination des = new StompJmsDestination("/queue/x");
        MessageProducer producer = session.createProducer(des);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for (int i = 0; i < 1000; i++) {
            TextMessage msg = session.createTextMessage("body" + i);
            msg.setIntProperty("id", 1);
            if (i % 5 == 0) {
                producer.send(msg, DeliveryMode.NON_PERSISTENT, 9, 3000);
            } else {
                producer.send(msg);
            }

        }
        System.out.println("send 1000 message");
//        producer.send(session.createTextMessage("SHUTDOWN"));

        connection.close();
    }
}
