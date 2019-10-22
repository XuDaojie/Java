package io.github.xudaojie.activemq.stomp;

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

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination des = new StompJmsDestination("stompQueue");
        MessageProducer producer = session.createProducer(des);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        TextMessage msg = session.createTextMessage("body");
        msg.setIntProperty("id", 10);
        producer.send(msg);

        producer.send(session.createTextMessage("SHUTDOWN"));

        connection.close();
    }
}
