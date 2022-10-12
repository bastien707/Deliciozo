package Main;

public class Pizza {
    private String name;
    private PizzaType type;
    private PizzaSize size;
    private int cookingTime;
    private double price;

    public Pizza(String name, PizzaType type, PizzaSize size, int cookingTime) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.cookingTime = cookingTime;
        this.price = calculPrice(size, type);
    }

    public String getName() {
        return name;
    }

    public PizzaType gettype() {
        return type;
    }

    public PizzaSize getSize() {
        return size;
    }

    public int getcookingTime() {
        return cookingTime;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void settype(PizzaType type) {
        this.type = type;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setcookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", cookingTime='" + cookingTime + '\'' +
                ", price=" + price +
                '}';
    }

    //method to calcul the price with the size and the type
    public double calculPrice(PizzaSize size, PizzaType type) {
        double price = 0;
        if (size == PizzaSize.small) {
            price = 5;
        } else if (size == PizzaSize.medium) {
            price = 7;
        } else if (size == PizzaSize.large) {
            price = 9;
        }
        if (type == PizzaType.ananas) {
            price += 1;
        } else if (type == PizzaType.vegetarian) {
            price += 2;
        } else if (type == PizzaType.thon) {
            price += 3;
        } else if (type == PizzaType.fromage) {
            price += 4;
        }
        return price;
    }
}