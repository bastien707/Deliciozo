package Scenario2.receiver;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;


public class MyReceiver implements Runnable {

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
                            int[] objReceived = (int[]) obj.getObject();
                            for (int i=0; i<objReceived.length; i++){
                                System.out.println(objReceived[i]);
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
}
