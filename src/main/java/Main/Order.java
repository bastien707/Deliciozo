package Main;

import java.util.Date;

public class Order {
    private int numOrder;
    private Date date;
    private String status;
    private Pizza[] pizzaOrder;
    private Product[] productOrder;
    private String phoneCustomer;

    public Order(int numOrder, Date date, String status, Pizza[] pizzaOrder, Product[] productOrder, String phoneCustomer) {
        this.numOrder = numOrder;
        this.date = date;
        this.status = status;
        this.pizzaOrder = pizzaOrder;
        this.productOrder = productOrder;
        this.phoneCustomer = phoneCustomer;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public Pizza[] getPizzaOrder() {
        return pizzaOrder;
    }

    public Product[] getProductOrder() {
        return productOrder;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPizzaOrder(Pizza[] pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    public void setProductOrder(Product[] productOrder) {
        this.productOrder = productOrder;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "numOrder=" + numOrder +
                ", phoneCustomer=" + phoneCustomer +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", pizzaOrder=" + pizzaOrder +
                ", productOrder=" + productOrder +
                '}';
    }

    public void endOrder(Order order) {
        System.out.println("Order finished");
        order.setStatus("Finished");
    }

    public void cancelOrder(Order order) {
        System.out.println("Order canceled");
        order.setStatus("Canceled");
    }
}
