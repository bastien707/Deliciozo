package Scenario2.receiver;

import javax.jms.*;

import Scenario2.Main.OrderAndCustomer;
import org.apache.activemq.ActiveMQConnectionFactory;


public class AssistantReceiver implements Runnable {
    private int idAssistant;

    public AssistantReceiver(int idAssistant) {
        this.idAssistant = idAssistant;
    }

    public void sendToCooker(OrderAndCustomer o){
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            javax.jms.Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("CommandeCree");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            ObjectMessage obj= session.createObjectMessage(o);
            System.out.println("Envoi de la commande de Monsieur " +o.getCustomer().getSurname()+" au cuisinier");
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
            Destination destination = session.createQueue("DemandeDePriseEnCharge");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try    {
                        if (message instanceof Object) {

                            ObjectMessage obj = (ObjectMessage) message;
                            OrderAndCustomer objReceived = (OrderAndCustomer) obj.getObject();
                            System.out.println("Demande de prise en charge du client "+objReceived.getCustomer().getId()
                                    +" recue par assistant" + idAssistant);
                            objReceived.setAssistantInCharge(idAssistant);
                            sendToCooker(objReceived);

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
