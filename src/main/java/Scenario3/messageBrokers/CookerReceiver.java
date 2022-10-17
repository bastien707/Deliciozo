package Scenario3.messageBrokers;

import javax.jms.*;

import Scenario3.Cooker;
import Scenario3.Customer;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.util.ArrayList;


public class CookerReceiver implements Runnable {
    private int cookerId;

    public CookerReceiver(int cookerId) {
        this.cookerId = cookerId;
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("PrepareDemand");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try    {
                        if (message instanceof Object) {

                            ObjectMessage obj = (ObjectMessage) message;
                            ArrayList<Customer> objReceived = (ArrayList<Customer>) obj.getObject();
                            System.out.println("Reception de commande par cuisinier "+ cookerId);
                            Cooker cooker = new Cooker(cookerId, objReceived);
                            cooker.preparePizza();

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
