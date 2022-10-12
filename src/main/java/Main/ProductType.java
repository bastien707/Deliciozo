package Main;

public enum ProductType {
        coca, fanta, sprite;

        public static ProductType fromString(String text) {
            if (text != null) {
                for (ProductType b : ProductType.values()) {
                    if (text.equalsIgnoreCase(b.name())) {
                        return b;
                    }
                }
            }
            return null;
        }
}
