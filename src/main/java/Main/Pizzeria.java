package Main;

import java.util.ArrayList;

public class Pizzeria {
    static ArrayList<Customer> customerList = new ArrayList<Customer>();
    static ArrayList<Cooker> cookerList = new ArrayList<Cooker>();
    static ArrayList<Order> orderList = new ArrayList<Order>();
    static ArrayList<DeliveryMan> deliveryManList = new ArrayList<DeliveryMan>();
    static ArrayList<Assistant>assistantList = new ArrayList<Assistant>();
    static ArrayList<String> pizzaList = new ArrayList<String>();
    static ArrayList<String> pizzaSizeList = new ArrayList<String>();
    static ArrayList<String> productList = new ArrayList<String>();

    public Pizzeria(ArrayList<Customer> customerList, ArrayList<Cooker> cookerList, ArrayList<Order> orderList, ArrayList<DeliveryMan> deliveryManList, ArrayList<Assistant>assistantList, ArrayList<String> pizzaList, ArrayList<String> productList){
        Pizzeria.customerList = customerList;
        Pizzeria.cookerList = cookerList;
        Pizzeria.orderList = orderList;
        Pizzeria.deliveryManList = deliveryManList;
        Pizzeria.assistantList = assistantList;
        Pizzeria.pizzaList = pizzaList;
        Pizzeria.productList = productList;
    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(ArrayList<Customer> customerList) {
        Pizzeria.customerList = customerList;
    }

    public static ArrayList<Cooker> getCookerList() {
        return cookerList;
    }

    public static void setCookerList(ArrayList<Cooker> cookerList) {
        Pizzeria.cookerList = cookerList;
    }

    public static ArrayList<Order> getOrderList() {
        return orderList;
    }

    public static void setOrderList(ArrayList<Order> orderList) {
        Pizzeria.orderList = orderList;
    }

    public static ArrayList<DeliveryMan> getDeliveryManList() {
        return deliveryManList;
    }

    public static void setDeliveryManList(ArrayList<DeliveryMan> deliveryManList) {
        Pizzeria.deliveryManList = deliveryManList;
    }

    public static ArrayList<Assistant> getAssistantList() {
        return assistantList;
    }

    public static void setAssistantList(ArrayList<Assistant> assistantList) {
        Pizzeria.assistantList = assistantList;
    }

    public static void setPizzaList(ArrayList<String> pizzaList) {
        Pizzeria.pizzaList = pizzaList;
    }

    public static void setPizzaSizeList(ArrayList<String> pizzaSizeList) {
        Pizzeria.pizzaSizeList = pizzaSizeList;
    }

    public static void setProductList(ArrayList<String> productList) {
        Pizzeria.productList = productList;
    }

    public static ArrayList<String> getProductList() {
        for (ProductType p: ProductType.values()){
            productList.add(p.name());
        }
        return productList;
    }

    public static ArrayList<String> getPizzaList() {
        for (PizzaType p: PizzaType.values()){
            pizzaList.add(p.name());
        }
        return pizzaList;
    }

    public static ArrayList<String> getPizzaSizeList() {
        for (PizzaSize p: PizzaSize.values()){
            pizzaSizeList.add(p.name());
        }
        return pizzaSizeList;
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
        orderList.add(newOrder);
    }
}
