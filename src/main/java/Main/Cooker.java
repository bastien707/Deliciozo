package Main;

import receiver.AssistantReceiver;
import receiver.CookerReceiver;

public class Cooker {
    private int cookerId;
    private Order listOrder;

    private static int nextCookerId=1;

    public Cooker() {
        cookerId = nextCookerId;
        nextCookerId++;
    }

    public Order getListOrder() {
        return listOrder;
    }

    public void setListOrder(Order listOrder) {
        this.listOrder = listOrder;
    }

    @Override
    public String toString() {
        return "Cooker{" +
                "listOrder=" + listOrder +
                '}';
    }

    public void startCooking(Order order) {
        System.out.println("Cooking...");
        order.setStatus("Cooking");
    }

    public void endCooking(Order order) {
        System.out.println("Cooking finished");
        order.setStatus("Cooked");
    }

    private static Thread thread(Runnable runnable, boolean daemon) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(daemon);
        thread.start();
        return thread;
    }

    public void listenAssistantDemand(){
        System.out.println("create thread cooker"+cookerId);
        thread(new CookerReceiver(cookerId), false);
    }
}
