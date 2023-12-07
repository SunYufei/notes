import factory.abs.AppleFactory;
import factory.abs.HuaweiFactory;
import factory.abs.Phone;
import factory.simple.Product;
import factory.simple.SimpleFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FactoryTest {
    @Test
    public void simple() {
        Product product = SimpleFactory.createProduct("A");
        assertNotNull(product);
        product.print();
    }

    @Test
    public void abs() {
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        AppleFactory appleFactory = new AppleFactory();
        Phone huawei = huaweiFactory.createPhone();
        Phone apple = appleFactory.createPhone();
        huawei.print();
        apple.print();
    }
}
