package Scenario2.Main;

public enum PizzaSize {
    small, medium, large;

    public static PizzaSize fromString(String text) {
        if (text != null) {
            for (PizzaSize b : PizzaSize.values()) {
                if (text.equalsIgnoreCase(b.name())) {
                    return b;
                }
            }
        }
        return null;
    }
}
