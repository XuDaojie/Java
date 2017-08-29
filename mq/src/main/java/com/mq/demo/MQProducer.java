package com.mq.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MQProducer {
    public static void main(String[] args) {
        try {
            queue();
//            topic();
//            queuet();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    static void queue() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://localhost:61616");
//        factory.setBrokerURL("failover:(tcp://localhost:61616,tcp://localhost:61626)");

        Connection connection = factory.createConnection("admin", "password");
        connection.start();

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination des = session.createQueue("my_queue");


        MessageProducer producer = session.createProducer(des);
        for (int i = 0; i < 300; i++) {
            // 创建一个文本消息
            TextMessage message = session.createTextMessage("A-张三-" + i);
            // 这里我们分别设置对应的消息信息，当成是一组消息
            message.setIntProperty("id", i);
            message.setStringProperty("JMSXGroupID", "A");
            producer.send(message);

            TextMessage message1 = session.createTextMessage("B-李四-" + i);
            message.setIntProperty("id", i);
            message1.setStringProperty("JMSXGroupID", "B");
            producer.send(message1);

            session.commit();
        }

        connection.close();
    }

    static void topic() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://localhost:61616");
//        factory.setBrokerURL("failover:(tcp://localhost:61616,tcp://localhost:61626)");

        Connection connection = factory.createConnection("admin", "password");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination des = session.createTopic("my_topic");

        MessageProducer producer = session.createProducer(des);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 0; i < 300; i++) {
            // 创建一个文本消息
            TextMessage message = session.createTextMessage("A-张三-" + i);
            // 这里我们分别设置对应的消息信息，当成是一组消息
            message.setIntProperty("id", i);
            message.setStringProperty("JMSXGroupID", "A");
            producer.send(message);

//            TextMessage message1 = session.createTextMessage("B-李四-" + i);
//            message.setIntProperty("id", i);
//            message1.setStringProperty("JMSXGroupID", "B");
//            producer.send(message1);
        }

        connection.close();
    }

    static void queuet() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://localhost:61616");
//        factory.setBrokerURL("failover:(tcp://localhost:61616,tcp://localhost:61626)");

        Connection connection = factory.createConnection("admin", "password");
        connection.start();

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination des = session.createQueue("my_queue");
//        MessageProducer producer = session.createProducer(des);
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//
//        for (int i = 0; i < 1000; i++) {
//            Message msgA = session.createTextMessage("textMsgA" + i);
////            msgA.setIntProperty("id", i);
//            msgA.setStringProperty("username", "A" + i);
//            producer.send(msgA);
//
//            Message msgB = session.createTextMessage("textMsgB" + i );
////            msgB.setIntProperty("id", i);
//            msgB.setStringProperty("username", "B");
//        }

        MessageProducer producer = session.createProducer(des);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        long start = System.currentTimeMillis();
        for (int i = 1; i < 100001; i++) {
            // 创建一个文本消息
            TextMessage message = session.createTextMessage("基于JMS的消息传递分为两方面，基于队列的点对点模式和对于主题的发布-订阅模式，这次主要针对Topic方式执行测试。\n" +
                    "测试中每个发送者和接收者所发送和接收的消息数目都将被记录。数值采样将会从测试系统初始化完成时开始，并在规定的时间段内持续进行，于系统开始关闭前结束.\n" +
                    "1.4 测试环境与配置\n" +
                    "所有的测试都在两台服务器（主从）上完成，消息消费者和提供者被安装在x86的机器上，配置为2.40G CPU和1.0GB内存，操作系统为Windows XP，所有机器在同一个网段的局域网内相连。\n" +
                    "1.5 测试场景\n" +
                    "1.5.1 集群类型\n" +
                    "本次性能测试主要测试比较几种Master-Slave集群配置方案和默认配置，我们对每个JMS项目采用默认的out-of-the-box配置。\n" +
                    "a.Pure Master Slave\n" +
                    "b.Shared File System Master Slave\n" +
                    "c.JDBC Master Slave（DB only）（采用默认数据源）\n" +
                    "d.JDBC Master Slave(File&DB）（采用c3P0数据源）\n" +
                    "e.单点非集群模式\n" +
                    "1.5.2 测试场景\n" +
                    "单个提供者，单个用户，和单个主题或队列（1 producer, 1 subscriber, and 1 topic）\n" +
                    "1.5.3 消息配置\n" +
                    "java.naming.provider.url：tcp://localhost:61616?jms.useAsyncSend=true&wireFormat.maxInactivityDuration=0\n" +
                    "消息发布时采用异步发送流（useAsyncSend）模式，加入wireFormat.maxInactivityDuration=0 这样的参数，避免ActiveMQ在一段时间没有消息发送时抛出 \"Channel was inactive for too long\"异常。\n" +
                    "消息内容：\n" +
                    "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><message><messageVersion>2</messageVersion><transactionId>17584926994300501924</transactionId><feeCode>2HSKYYXC</feeCode><spcode>11</spcode><phoneNum>13886344486</phoneNum><hsMan>rebound</hsMan><hsType>f420</hsType><vmVer>1940</vmVer><hsVer>101935</hsVer><imei>135790246811220</imei><imsi>460005804931145</imsi><appId>400001</appId><appVer>-1</appVer><feetype>0</feetype><provider>1</provider><reserve>0</reserve><moTime>20090708175847</moTime><cost>2.0</cost><chargeVer>0</chargeVer><application>0</application><module>0</module><appcontext>ABcWEwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==</appcontext></message>\n" +
                    "消息大小646字节，会被消息产生者重复使用。\n" +
                    "1.5.4 ActiveMQ相关\n" +
                    "部署的ActiveMQ版本为现网部署的5.1.0版本。\n" +
                    "采用AMQ Message Store的ActiveMQ缺省持久化存储方式，所有方案持久化使能persistent=”true”,日志等级设置为INFO。持久化时配置增大ActiveMQ缓存大小，<policyEntry queue=\">\" memoryLimit=\"100mb\"/><policyEntry topic=\">\" memoryLimit=\"100mb\"/>。\n" +
                    "1.5.5.测试方案\n" +
                    "方案一：在测试PC1上使用asdasd基于JMS的消息传递分为两方面，基于队列的点对点模式和对于主题的发布-订阅模式，这次主要针对Topic方式执行测试。\n" +
                    "测试中每个发送者和接收者所发送和接收的消息数目都将被记录。数值采样将会从测试系统初始化完成时开始，并在规定的时间段内持续进行，于系统开始关闭前结束.\n" +
                    "1.4 测试环境与配置\n" +
                    "所有的测试都在两台服务器（主从）上完成，消息消费者和提供者被安装在x86的机器上，配置为2.40G CPU和1.0GB内存，操作系统为Windows XP，所有机器在同一个网段的局域网内相连。\n" +
                    "1.5 测试场景\n" +
                    "1.5.1 集群类型\n" +
                    "本次性能测试主要测试比较几种Master-Slave集群配置方案和默认配置，我们对每个JMS项目采用默认的out-of-the-box配置。\n" +
                    "a.Pure Master Slave\n" +
                    "b.Shared File System Master Slave\n" +
                    "c.JDBC Master Slave（DB only）（采用默认数据源）\n" +
                    "d.JDBC Master Slave(File&DB）（采用c3P0数据源）\n" +
                    "e.单点非集群模式\n" +
                    "1.5.2 测试场景\n" + i);
            // 这里我们分别设置对应的消息信息，当成是一组消息
            message.setIntProperty("id", i);
            message.setStringProperty("JMSXGroupID", "A");
            producer.send(message);

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
            session.commit();
            // 2 12 114
            // 0 2 9
            // 2 18 167 //事务
            // 1 8 30

//            TextMessage message1 = session.createTextMessage("B-李四-" + i);
//            message.setIntProperty("id", i);
//            message1.setStringProperty("JMSXGroupID", "B");
//            producer.send(message1);
        }

        connection.close();
    }
}
