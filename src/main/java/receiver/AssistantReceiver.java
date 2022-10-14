package receiver;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;


public class AssistantReceiver implements Runnable {
    private int idClientReceived;

    public int getIdClientReceived() {
        return idClientReceived;
    }

    public void setIdClientReceived(int idClientReceived) {
        this.idClientReceived = idClientReceived;
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("DemandeDePriseEnCharge");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try    {
                        if (message instanceof Object) {

                            ObjectMessage obj = (ObjectMessage) message;
                            int objReceived = (int) obj.getObject();
                            System.out.println("Demande de prise en charge du client "+objReceived+"recue");
                            setIdClientReceived(objReceived);

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
