package Scenario3.messageBrokers;

import javax.jms.*;

import Scenario3.Customer;
import org.apache.activemq.ActiveMQConnectionFactory;


public class DeliverReceiver implements Runnable {
    private int deliverId;

    public DeliverReceiver(int deliverId) {
        this.deliverId = deliverId;
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("CommandReady");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try    {
                        if (message instanceof Object) {

                            ObjectMessage obj = (ObjectMessage) message;
                            Customer objReceived = (Customer) obj.getObject();
                            System.out.println("Commande de " + objReceived.getNom() +" recue par le livreur " + deliverId);

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
}
