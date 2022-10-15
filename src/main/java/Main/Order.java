package Main;

import java.util.Date;

public class Order {
    private int numOrder;
    private Date date;
    private String status;
    private Pizza[] pizzaOrder;
    private Product[] productOrder;
    private String phoneCustomer;
    private double bill;

    public Order(int numOrder, Date date, String status, Pizza[] pizzaOrder, Product[] productOrder, String phoneCustomer) {
        this.numOrder = numOrder;
        this.date = date;
        this.status = status;
        this.pizzaOrder = pizzaOrder;
        this.productOrder = productOrder;
        this.phoneCustomer = phoneCustomer;
        this.bill = calculBill(pizzaOrder, productOrder);
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

    public double getBill() {
        return bill;
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

    public void setBill(double bill) {
        this.bill = bill;
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

    //method to calcul the bill by adding the price of the pizzas and the products
    public double calculBill(Pizza[] pizzaOrder, Product[] productOrder) {
        double bill = 0;
        for (int i = 0; i < pizzaOrder.length; i++) {
            bill += pizzaOrder[i].getPrice();
        }
        for (int i = 0; i < productOrder.length; i++) {
            bill += productOrder[i].getPrice();
        }
        return bill;
    }
}
