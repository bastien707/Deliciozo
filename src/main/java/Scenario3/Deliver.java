package Scenario3;

import Scenario3.messageBrokers.AssistantReceiver;
import Scenario3.messageBrokers.DeliverReceiver;

import static Scenario3.Main.thread;

public class Deliver {
    private int idDeliver;
    private static int nextIdDeliver=1;

    public Deliver() {
        this.idDeliver = nextIdDeliver;
        nextIdDeliver++;
    }

    public void listenCookerDemand(){
        thread(new DeliverReceiver(idDeliver), false);
    }
}
