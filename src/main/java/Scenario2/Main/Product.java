package Scenario2.Main;

import java.io.Serializable;

public class Product implements Serializable {
    private ProductType type;
    private double price;
    private int quantity;

    public Product(ProductType type, int quantity) {
        this.type = type;
        this.price = calculPrice(type, quantity);
        this.quantity = quantity;
    }

    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public double calculPrice(ProductType type, int quantity) {
        double price = 0;
        switch (type) {
            case coca:
                price = 1.5;
                break;
            case fanta:
                price = 2.5;
                break;
            case sprite:
                price = 3.5;
                break;
        }
        return price * quantity;
    }
}