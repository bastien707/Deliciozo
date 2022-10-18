package Scenario3;

import Scenario3.messageBrokers.CookerSender;

import java.io.Serializable;
import java.util.ArrayList;

import static Scenario3.Main.thread;

public class Cooker implements Serializable {
    private int idCooker;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Cooker(int id, ArrayList<Customer> list) {
        this.idCooker = id;
        this.customers = list;
    }

    public int getIdCooker() {
        return idCooker;
    }

    public void setIdCooker(int idCooker) {
        this.idCooker = idCooker;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void preparePizza(){
        PizzaPreparation p = new PizzaPreparation(customers, idCooker);
        p.preparePizza();
    }

    public static void sendToDeliver(Customer c){
        thread(new CookerSender(c), false);
    }

}
