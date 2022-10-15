package Main;

import receiver.AssistantReceiver;
import receiver.DeliverReceiver;

public class DeliveryMan {
    private int numDelivery;
    private double bill;
    private double waller;
    private Order listOrder;

    private static int nextDeliverId=1;

    public DeliveryMan(double bill, double waller) {
        this.numDelivery = nextDeliverId;
        this.bill = bill;
        this.waller = waller;
        nextDeliverId++;
    }

    public int getNumDelivery() {
        return numDelivery;
    }

    public double getBill() {
        return bill;
    }

    public double getWaller() {
        return waller;
    }

    public Order getListOrder() {
        return listOrder;
    }

    public void setNumDelivery(int numDelivery) {
        this.numDelivery = numDelivery;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public void setWaller(double waller) {
        this.waller = waller;
    }

    public void setListOrder(Order listOrder) {
        this.listOrder = listOrder;
    }

    @Override
    public String toString() {
        return "DeliveryMan{" +
                "numDelivery=" + numDelivery +
                ", bill=" + bill +
                ", waller=" + waller +
                ", listOrder=" + listOrder +
                '}';
    }

    public void deliver(Order order) {
        System.out.println("Delivering...");
        order.setStatus("Delivering");
    }

    public void endDeliver(Order order) {
        System.out.println("Delivering finished");
        order.setStatus("Delivered");
    }

    private static Thread thread(Runnable runnable, boolean daemon) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(daemon);
        thread.start();
        return thread;
    }

    public void listenCookerDemand(){
        System.out.println("create thread deliver "+numDelivery);
        thread(new DeliverReceiver(numDelivery), false);
    }
}