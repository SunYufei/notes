package factory.simple;

public class SimpleFactory {
    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        }
        if ("B".equals(type)) {
            return new ProductB();
        }
        return null;
    }
}
