package Scenario3.messageBrokers;

import javax.jms.*;

import Scenario3.Customer;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.util.ArrayList;


public class AssistantReceiver implements Runnable {
    private int assistandId;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public AssistantReceiver(int assistandId) {
        this.assistandId = assistandId;
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("ClientDemand");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try    {
                        if (message instanceof Object) {

                            ObjectMessage obj = (ObjectMessage) message;
                            Customer objReceived = (Customer) obj.getObject();
                            System.out.println("Reception de commande de " + objReceived.getNom() +" par assistant "+ assistandId);
                            customers.add(objReceived);
                            if(customers.size() == 2){
                                System.out.println("Envoi des commandes de l'assistant " + assistandId  +" aux cuisiniers");
                                sendToCooker(customers);
                                customers=null;
                            }
                        } else {
                            System.out.println("Received: " + message);
                        }
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sendToCooker(ArrayList<Customer> customer){
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            javax.jms.Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("PrepareDemand");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            ObjectMessage obj= session.createObjectMessage(customer);
            producer.send(obj);

            session.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
