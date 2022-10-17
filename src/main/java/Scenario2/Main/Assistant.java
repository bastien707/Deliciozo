package Scenario2.Main;
import Scenario2.receiver.AssistantReceiver;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Assistant {
    private int numAssistant;
    private ArrayList<Order> listOrder = new ArrayList<Order>();

    public Assistant(int numAssistant) {
        this.numAssistant = numAssistant;
        this.listOrder = new ArrayList<Order>();
    }

    public int getNumAssistant() {
        return numAssistant;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void setNumAssistant(int numAssistant) {
        this.numAssistant = numAssistant;
    }

    public void setListOrder(ArrayList<Order> listOrder) {
        this.listOrder = listOrder;
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "numAssistant=" + numAssistant +
                ", listOrder=" + listOrder +
                '}';
    }

    public void takeOrder() {
        System.out.println("Taking order...");
    }

    public void endTakeOrder() {
        System.out.println("Taking order finished");
    }

    //give order to deliveryMan
    public void giveOrder(DeliveryMan deliveryMan, Order order) {
        deliveryMan.setListOrder(order);
        System.out.println("Giving order to deliveryMan");
    }

    //give order to cooker
    public void giveOrder(Cooker cooker, Order order) {
        cooker.setListOrder(order);
        System.out.println("Giving order to cooker");
    }

    //notify the Customer that is order is being prepared
    public void notifyCustomer() {
        System.out.println("You're order is being prepared...");
    }

    //Ask if it's his first time ordering and recup the answer with scanner
    public void askFirstTime(Scanner scanner) {
        System.out.println("Is it your first time ordering? (y/n)");
            String answer = scanner.nextLine();
            if (answer.equals("y")) {
                System.out.println("Welcome to our restaurant!");
            } else {
                System.out.println("Welcome back!");
            }

    }

    //if it's his first time ordering, ask for his information then create a customer
    public Customer createCustomer(Scanner scanner) {
        System.out.println("Please enter your surname");
        String surname = scanner.nextLine();
        System.out.println("Please enter your firstname");
        String firstname = scanner.nextLine();
        System.out.println("Please enter your address");
        String address = scanner.nextLine();
        System.out.println("Please enter your phone number");
        String phoneNumber = scanner.nextLine();
        Date dateFirstOrder = new Date(System.currentTimeMillis());
        Customer customer = new Customer(surname, firstname, address, phoneNumber, dateFirstOrder);
        System.out.println("Customer created");
        return customer;

    }

    //if it's not his first time ordering, ask for his phone number and compare with the list of customers
    public Customer findCustomer() {
        System.out.println("Please enter your phone number");
        try (Scanner scanner = new Scanner(System.in)) {
            String phoneNumber = scanner.nextLine();
            for(Customer customer : Pizzeria.getCustomerList()) {
                if (customer.getPhone().equals(phoneNumber)) {
                    System.out.println("Customer found");
                    return customer;
                }
            }
            System.out.println("Customer not found");
            return null;
        }
    }

    //ask for what he wants and then create an order
    public Order createOrder(Scanner scanner,int i, Customer customer) {
        i = i+1;
        System.out.println("How many pizza do you want?");
        String Nbpizza = scanner.nextLine();
        Pizza[] pizzalist = new Pizza[Integer.parseInt(Nbpizza)];
        for(int j = 0; j < Integer.parseInt(Nbpizza); j++) {
            System.out.println("What pizza do you want?");
            //show all type of pizza
            for (String s : Pizzeria.getPizzaList()) {
                System.out.println(s);
            }
            String namePizza = scanner.nextLine();

            System.out.println("What type of pizza do you want?");
            //show all type of pizza
            for (String s : Pizzeria.getPizzaList()) {
                System.out.println(s);
            }
            String typePizza = scanner.nextLine();
            PizzaType TypePizza = PizzaType.fromString(typePizza);

            System.out.println("What size of pizza do you want?");
            //show all size of pizza
            for (String s: Pizzeria.getPizzaSizeList()) {
                System.out.println(s);
            }
            String sizePizza = scanner.nextLine();
            PizzaSize SizePizza = PizzaSize.fromString(sizePizza);

            int cookingTime = (int)Math.floor(Math.random()*(30-15+1)+15);
            //create the pizza and add it to a pizza list
            Pizza pizza = new Pizza(namePizza, TypePizza, SizePizza, cookingTime);
            pizzalist[j] = pizza;
        }

        System.out.println("How many products do you want?");
        String Nbproducts = scanner.nextLine();
        Product[] productlist = new Product[Integer.parseInt(Nbproducts)];
        for(int k = 0; k < Integer.parseInt(Nbproducts); k++) {
            System.out.println("What product do you want?");
            //show all type of products
            for (String s : Pizzeria.getProductList()) {
                System.out.println(s);
            }
            String nameProduct = scanner.nextLine();
            ProductType TypeProduct = ProductType.fromString(nameProduct);

            System.out.println("How many of this product do you want?");
            String quantityProduct = scanner.nextLine();
            //create the product and add it to a product list
            Product product = new Product(TypeProduct, Integer.parseInt(quantityProduct));
            productlist[k] = product;
        }

        Date dateOrder = new Date(System.currentTimeMillis());
        Order newOrder = new Order(i, dateOrder, "Started",   pizzalist, productlist, customer.getPhone());
        System.out.println("Order created");
        //add the order to the list of order
        Pizzeria.addOrder(newOrder);
        //add the order to the list of order of the assistant
        this.addOrder(newOrder);
        return newOrder;
    }

    private void addOrder(Order newOrder) {
        listOrder.add(newOrder);
    }

    private static Thread thread(Runnable runnable, boolean daemon) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(daemon);
        thread.start();
        return thread;
    }

    public void listenCustomerDemand(int idAssistant){
        System.out.println("create thread assistant"+idAssistant);
        thread(new AssistantReceiver(idAssistant), false);
    }
}
