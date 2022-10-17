package Scenario3;

import Scenario3.messageBrokers.CustomerSender;

import java.io.Serializable;

public class Customer implements Serializable {
    private String nom;
    private Pizza pizza;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Customer(String nom, Pizza pizza) {
        this.nom = nom;
        this.pizza = pizza;
    }

}
