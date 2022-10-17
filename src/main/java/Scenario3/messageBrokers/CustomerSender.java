package Scenario3.messageBrokers;

import javax.jms.*;

import Scenario3.Customer;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.util.ArrayList;


public class CustomerSender implements Runnable{
    ArrayList<Customer> customersToSend =new ArrayList<Customer>();
    private int group;

    public CustomerSender(ArrayList<Customer> customersToSend, int group) {
        this.customersToSend = customersToSend;
        this.group = group;
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            javax.jms.Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("ClientDemand");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            ObjectMessage obj= session.createObjectMessage(customersToSend.get(0));
            obj.setStringProperty("JMSXGroupID", "Group-"+group);
            obj.setIntProperty("JMSXGroupSeq", 1);
            producer.send(obj);

            ObjectMessage obj2= session.createObjectMessage(customersToSend.get(1));
            obj2.setStringProperty("JMSXGroupID", "Group-"+group);
            obj2.setIntProperty("JMSXGroupSeq", 2);
            producer.send(obj2);


            session.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

