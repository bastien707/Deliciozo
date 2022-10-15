package sender;

import javax.jms.*;

import Main.Customer;
import Main.OrderAndCustomer;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.io.Serializable;


public class CustomerSender implements Runnable{
    private OrderAndCustomer demand;

    public CustomerSender(OrderAndCustomer c){
        this.demand = c;
    }
    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            javax.jms.Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("DemandeDePriseEnCharge");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            ObjectMessage obj= session.createObjectMessage(demand);
            System.out.println("Sending the customer id :"+demand.getCustomer().getId());
            producer.send(obj);
            session.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

