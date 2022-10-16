package Main;

public class Main {
    public static void main(String[] args) {
        //create 3 pizzas of each size and types
        Pizza pizza1 = new Pizza("Pizza1", PizzaType.vegetarian, PizzaSize.small, 10);
        Pizza pizza2 = new Pizza("Pizza2", PizzaType.ananas, PizzaSize.small, 10);
        Pizza pizza3 = new Pizza("Pizza3", PizzaType.thon, PizzaSize.small, 10);
        Pizza pizza4 = new Pizza("Pizza4", PizzaType.fromage, PizzaSize.small, 10);
        Pizza pizza5 = new Pizza("Pizza5", PizzaType.vegetarian, PizzaSize.medium, 10);
        Pizza pizza6 = new Pizza("Pizza6", PizzaType.ananas, PizzaSize.medium, 10);
        Pizza pizza7 = new Pizza("Pizza7", PizzaType.thon, PizzaSize.medium, 10);
        Pizza pizza8 = new Pizza("Pizza8", PizzaType.fromage, PizzaSize.medium, 10);
        Pizza pizza9 = new Pizza("Pizza9", PizzaType.vegetarian, PizzaSize.large, 10);
        Pizza pizza10 = new Pizza("Pizza10", PizzaType.ananas, PizzaSize.large, 10);
        Pizza pizza11 = new Pizza("Pizza11", PizzaType.thon, PizzaSize.large, 10);
        Pizza pizza12 = new Pizza("Pizza12", PizzaType.fromage, PizzaSize.large, 10);

        //get the pizza in the pizzaList of pizzeria
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.addPizza(pizza1);
        pizzeria.addPizza(pizza2);
        pizzeria.addPizza(pizza3);
        pizzeria.addPizza(pizza4);
        pizzeria.addPizza(pizza5);
        pizzeria.addPizza(pizza6);
        pizzeria.addPizza(pizza7);
        pizzeria.addPizza(pizza8);
        pizzeria.addPizza(pizza9);
        pizzeria.addPizza(pizza10);
        pizzeria.addPizza(pizza11);
        pizzeria.addPizza(pizza12);

        //listOrders empty
        Order[] orders = new Order[0];

        //create 2 assistants
        Assistant assistant1 = new Assistant(1, orders);
        Assistant assistant2 = new Assistant(2, orders);

        //create 2 cooks
        Cook cook1 = new Cook(1, orders);
        Cook cook2 = new Cook(2, orders);

        //create 2 deliverymans
        DeliveryMan deliveryMan1 = new DeliveryMan(1, 0, 0, orders);
        DeliveryMan deliveryMan2 = new DeliveryMan(2, 0, 0, orders);

        Customer customer = assistant1.askFirstTime();

    }
    
}
