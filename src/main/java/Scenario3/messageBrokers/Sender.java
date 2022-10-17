package Scenario3.messageBrokers;

import javax.jms.*;

import Scenario2.Main.OrderAndCustomer;
import org.apache.activemq.ActiveMQConnectionFactory;


public class Sender implements Runnable{
    private int a=1;
    private int b=7;

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            javax.jms.Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("DQueue");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            ObjectMessage obj= session.createObjectMessage(a);
            obj.setStringProperty("JMSXGroupID", "Group-0");
            obj.setIntProperty("JMSXGroupSeq", 1);
            producer.send(obj);

            ObjectMessage obj2= session.createObjectMessage(b);
            obj2.setStringProperty("JMSXGroupID", "Group-0");
            obj2.setIntProperty("JMSXGroupSeq", 2);
            producer.send(obj2);


            session.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

