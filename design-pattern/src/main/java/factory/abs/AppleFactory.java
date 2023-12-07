package factory.abs;

public class AppleFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new Apple();
    }
}
