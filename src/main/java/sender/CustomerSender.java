package sender;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;


public class CustomerSender implements Runnable{
    private int IdClient;

    public CustomerSender(int ID){
        this.IdClient = ID;
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
            ObjectMessage obj= session.createObjectMessage(IdClient);
            System.out.println("Sending the customer id :"+IdClient);
            producer.send(obj);
            session.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

