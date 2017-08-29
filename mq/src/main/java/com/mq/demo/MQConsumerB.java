package com.mq.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MQConsumerB {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                "admin", "password", "tcp://localhost:61616");

        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination des = session.createQueue("my_queue");
        // 创建消费者
        MessageConsumer consumer = session.createConsumer(des, "JMSXGroupID='B'");
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("B:" + message.getText());
            if ("SHUTDOWN".equals(message.getText())) {
                break;
            }
        }
//        consumer.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//                TextMessage textMessage = (TextMessage) message;
//                try {
//                    System.out.println("B:"+textMessage.getText());
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        connection.close();
    }
}
