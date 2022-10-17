package Scenario3;

import Scenario3.messageBrokers.AssistantReceiver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Assistant {
    private int idAssitant;
    ArrayList<Customer> customers;
    private static int nextAssistantId=1;

    public Assistant(ArrayList<Customer> customers) {
        this.idAssitant = nextAssistantId;
        nextAssistantId++;
        this.customers = customers;
    }

    public static Thread thread(Runnable runnable, boolean daemon) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(daemon);
        thread.start();
        return thread;
    }

    public void listenCustomerDemand(){
        thread(new AssistantReceiver(idAssitant), false);
    }

}
