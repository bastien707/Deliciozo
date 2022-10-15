package Main;

public class DeliveryMan {
    private int numDelivery;
    private double bill;
    private double waller;
    private Order Order;

    public DeliveryMan(int numDelivery, double bill, double waller, Order Order) {
        this.numDelivery = numDelivery;
        this.bill = bill;
        this.waller = waller;
        this.Order = Order;
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

    public Order getOrder() {
        return Order;
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

    public void setListOrder(Order Order) {
        this.Order = Order;
    }

    @Override
    public String toString() {
        return "DeliveryMan{" +
                "numDelivery=" + numDelivery +
                ", bill=" + bill +
                ", waller=" + waller +
                ", listOrder=" + Order +
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
}