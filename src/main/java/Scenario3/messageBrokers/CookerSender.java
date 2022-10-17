package Scenario3.messageBrokers;

import javax.jms.*;

import Scenario3.Customer;
import org.apache.activemq.ActiveMQConnectionFactory;


public class CookerSender implements Runnable{
    private Customer customer;

    public CookerSender(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            javax.jms.Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("CommandReady");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            System.out.println("Envoi de la commande de "+ customer.getNom()+" aux livreurs");
            ObjectMessage obj= session.createObjectMessage(customer);
            producer.send(obj);

            session.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

