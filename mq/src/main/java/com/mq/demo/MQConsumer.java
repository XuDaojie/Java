package com.mq.demo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicConnection;

public class MQConsumer {
    public static void main(String[] args) throws JMSException {
        queue();
//        topic();
//        queuet();
    }

    static void queue() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                "admin", "password", "tcp://localhost:61616");
//        factory.setBrokerURL("failover:(tcp://localhost:61616,tcp://localhost:61626)");

        QueueConnection connection = factory.createQueueConnection();
        connection.start();

        final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
//        Destination des = session.createQueue("my_queue");
        ActiveMQQueue queue = new ActiveMQQueue("my_queue?consumer.dispatchAsync=false&consumer.prefetchSize=10");
//        Destination des = ((QueueSession)session).createReceiver(queue);
        MessageConsumer consumer = ((QueueSession)session).createReceiver(queue);

        while (true) {
            TextMessage msg = (TextMessage) consumer.receive();
            String body = msg.getText();
            System.out.println(body);

            if ("SHUTDOWN".equals(body)) {
                break;
            }
        }

        connection.close();
    }

    static void topic() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                "admin", "password", "tcp://localhost:61616");
//        factory.setBrokerURL("failover:(tcp://localhost:61616,tcp://localhost:61626)");

        TopicConnection connection = factory.createTopicConnection();
        connection.setClientID("client_id");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Destination des = session.createQueue("my_queue");
        ActiveMQTopic topic = new ActiveMQTopic("my_topic?consumer.dispatchAsync=false&consumer.prefetchSize=10");
//        Destination des = ((QueueSession)session).createReceiver(queue);
//        MessageConsumer consumer = session.createConsumer(queue);
        MessageConsumer consumer = session.createDurableSubscriber(topic, "client_id");

        while (true) {
            TextMessage msg = (TextMessage) consumer.receive();
            String body = msg.getText();
            System.out.println(body);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ("SHUTDOWN".equals(body)) {
                break;
            }
        }

        connection.close();
    }

    static void queuet() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                "admin", "password", "tcp://localhost:61616");
//        factory.setBrokerURL("failover:(tcp://localhost:61616,tcp://localhost:61626)");

        QueueConnection connection = factory.createQueueConnection();
        connection.start();

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
//        Destination des = session.createQueue("my_queue");
        ActiveMQQueue queue = new ActiveMQQueue("my_queue?consumer.dispatchAsync=false&consumer.prefetchSize=10");
//        Destination des = ((QueueSession)session).createReceiver(queue);
        MessageConsumer consumer = ((QueueSession)session).createReceiver(queue);

        int i = 0;
        long start = System.currentTimeMillis();
        while (true) {
            TextMessage msg = (TextMessage) consumer.receive();
            String body = msg.getText();
//            System.out.println(body);
            session.commit();
            if (i == 1000) {
                long end = System.currentTimeMillis();
                long s = (end - start);
                System.err.println("1000条" + s + "ms");
            } else if (i == 10000) {
                long end = System.currentTimeMillis();
                long s = (end - start);
                System.err.println("10000条" + s + "ms");
            } else if (i == 100000) {
                long end = System.currentTimeMillis();
                long s = (end - start);
                System.err.println("10000条" + s + "ms");
            }
            if ("SHUTDOWN".equals(body)) {
                break;
            }
            ++i;
        }
        // 3 25 182
        connection.close();
    }

}
