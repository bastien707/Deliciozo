package Scenario3;

import java.io.Serializable;

public class Pizza implements Serializable {
    private int timeToCook;
    private String flavour;

    public int getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(int timeToCook) {
        this.timeToCook = timeToCook;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public Pizza(int timeToCook, String flavour) {
        this.timeToCook = timeToCook;
        this.flavour = flavour;
    }
}
