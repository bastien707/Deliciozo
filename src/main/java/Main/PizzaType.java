package Main;

public enum PizzaType {
    vegetarian, ananas, thon, fromage;

    public static PizzaType fromString(String text) {
        if (text != null) {
            for (PizzaType b : PizzaType.values()) {
                if (text.equalsIgnoreCase(b.name())) {
                    return b;
                }
            }
        }
        return null;
    }
}
