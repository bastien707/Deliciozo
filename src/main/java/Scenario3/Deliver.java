package Scenario3;

import Scenario3.messageBrokers.AssistantReceiver;
import Scenario3.messageBrokers.DeliverReceiver;

public class Deliver {
    private int idDeliver;
    private static int nextIdDeliver=1;

    public Deliver() {
        this.idDeliver = nextIdDeliver;
        nextIdDeliver++;
    }

    public static Thread thread(Runnable runnable, boolean daemon) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(daemon);
        thread.start();
        return thread;
    }

    public void listenCookerDemand(){
        thread(new DeliverReceiver(idDeliver), false);
    }
}
