package factory.abs;

public class HuaweiFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new Huawei();
    }
}
