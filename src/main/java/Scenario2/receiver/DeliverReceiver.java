package Scenario2.receiver;

import Scenario2.Main.OrderAndCustomer;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class DeliverReceiver implements Runnable{
    private int idDeliver;

    public DeliverReceiver(int idDeliver) {
        this.idDeliver = idDeliver;
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("CommandePrete");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try    {
                        if (message instanceof Object) {

                            ObjectMessage obj = (ObjectMessage) message;
                            OrderAndCustomer objReceived = (OrderAndCustomer) obj.getObject();
                            System.out.println("Commande de monsieur "+objReceived.getCustomer().getSurname()
                                    +" recue par le livreur "+idDeliver);

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
