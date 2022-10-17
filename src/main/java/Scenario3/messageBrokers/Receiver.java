package Scenario3.messageBrokers;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;


public class Receiver implements Runnable {

    private int idReceiver;

    public Receiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("DQueue");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try    {
                        if (message instanceof Object) {

                            ObjectMessage obj = (ObjectMessage) message;
                            int objReceived = (int) obj.getObject();
                            System.out.println("Received: " + objReceived +" by receiver "+ idReceiver);

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
