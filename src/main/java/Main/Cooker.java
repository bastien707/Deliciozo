package Main;

public class Cooker {
    private Order listOrder;

    public Cooker(Order listOrder) {
        this.listOrder = listOrder;
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
}
