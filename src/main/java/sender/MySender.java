package sender;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;


public class MySender implements Runnable{
	@Override
	public void run() {
		try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            javax.jms.Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("DQueue");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            String text = "Hello world from: ";
            TextMessage message = session.createTextMessage(text);
            producer.send(message);
            session.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
	}

}
