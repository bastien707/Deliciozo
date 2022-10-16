package Main;

public class Cooker {
    private int numCooker;
    private Order[] listOrder;

    public Cooker( int numCooker ,Order[] listOrder) {
        this.numCooker = numCooker;
        this.listOrder = listOrder;
    }

    public int getNumCooker() {
        return numCooker;
    }

    public Order[] getListOrder() {
        return listOrder;
    }

    public void setNumCooker(int numCooker) {
        this.numCooker = numCooker;
    }

    public void setListOrder(Order[] listOrder) {
        this.listOrder = listOrder;
    }


    @Override
    public String toString() {
        return "Cooker{" +
                ", numCooker=" + numCooker +
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
