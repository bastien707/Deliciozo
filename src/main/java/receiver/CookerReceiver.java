package receiver;

import Main.OrderAndCustomer;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class CookerReceiver implements Runnable {
    private int cookerId;

    public CookerReceiver(int cookerId) {
        this.cookerId = cookerId;
    }

    public void sendToDeliver(OrderAndCustomer o){
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            javax.jms.Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("CommandePrete");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            ObjectMessage obj= session.createObjectMessage(o);
            System.out.println("Envoi de la commande de Monsieur " +o.getCustomer().getSurname()+" aux livreurs");
            producer.send(obj);
            session.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("CommandeCree");
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
                                    +" recue par le cuisinier "+cookerId);
                            sendToDeliver(objReceived);

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
