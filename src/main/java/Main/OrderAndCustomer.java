package Main;

import java.io.Serializable;

public class OrderAndCustomer implements Serializable {
    private int assistantInCharge;
    private Customer customer;
    private Order order;

    public int getAssistantInCharge() {
        return assistantInCharge;
    }

    public void setAssistantInCharge(int assistantInCharge) {
        this.assistantInCharge = assistantInCharge;
    }

    public OrderAndCustomer(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
