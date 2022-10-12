package Main;

public class Pizzeria {
    static Customer[] customerList;
    static Cooker[] cookerList;
    static Order[] orderList;
    static DeliveryMan[] deliveryManList;
    static Assistant[] assistantList;
    static Pizza[] pizzaList;
    static Product[] productList;

    public Pizzeria(Customer[] customerList, Cooker[] cookerList, Order[] orderList, DeliveryMan[] deliveryManList, Assistant[] assistantList, Pizza[] pizzaList, Product[] productList) {
        Pizzeria.customerList = customerList;
        Pizzeria.cookerList = cookerList;
        Pizzeria.orderList = orderList;
        Pizzeria.deliveryManList = deliveryManList;
        Pizzeria.assistantList = assistantList;
        Pizzeria.pizzaList = pizzaList;
        Pizzeria.productList = productList;
    }

    public static Customer[] getCustomerList() {
        return customerList;
    }

    public static Cooker[] getCookerList() {
        return cookerList;
    }

    public static Order[] getOrderList() {
        return orderList;
    }

    public static DeliveryMan[] getDeliveryManList() {
        return deliveryManList;
    }

    public static Assistant[] getAssistantList() {
        return assistantList;
    }

    public static Pizza[] getPizzaList() {
        return pizzaList;
    }

    public static Product[] getProductList() {
        return productList;
    }

    public static void setCustomerList(Customer[] customerList) {
        Pizzeria.customerList = customerList;
    }

    public static void setCookerList(Cooker[] cookerList) {
        Pizzeria.cookerList = cookerList;
    }

    public static void setOrderList(Order[] orderList) {
        Pizzeria.orderList = orderList;
    }

    public static void setDeliveryManList(DeliveryMan[] deliveryManList) {
        Pizzeria.deliveryManList = deliveryManList;
    }

    public static void setAssistantList(Assistant[] assistantList) {
        Pizzeria.assistantList = assistantList;
    }

    public static void setPizzaList(Pizza[] pizzaList) {
        Pizzeria.pizzaList = pizzaList;
    }

    public static void setProductList(Product[] productList) {
        Pizzeria.productList = productList;
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "customerList=" + customerList +
                ", cookerList=" + cookerList +
                ", orderList=" + orderList +
                ", deliveryManList=" + deliveryManList +
                ", assistantList=" + assistantList +
                ", pizzaList=" + pizzaList +
                ", productList=" + productList +
                '}';
    }

    public static void addOrder(Order newOrder) {
        Order[] newOrderList = new Order[orderList.length + 1];
        for (int i = 0; i < orderList.length; i++) {
            newOrderList[i] = orderList[i];
        }
        newOrderList[newOrderList.length - 1] = newOrder;
        orderList = newOrderList;
    }
}
