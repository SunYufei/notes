import org.junit.jupiter.api.Test;
import singleton.*;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {
    @Test
    public void hungry() {
        Resource r1 = HungrySingleton.getInstance();
        Resource r2 = HungrySingleton.getInstance();
        assertSame(r1, r2);
        System.out.println(r1.name());
    }

    @Test
    public void lazy() {
        Resource r1 = LazySingleton.getInstance();
        Resource r2 = LazySingleton.getInstance();
        assertSame(r1, r2);
        System.out.println(r1.name());
        Resource r3 = LazySingleton.getInstanceV2();
        assertSame(r1, r3);
    }

    @Test
    public void inner() {
        Resource r1 = InnerClassSingleton.getInstance();
        Resource r2 = InnerClassSingleton.getInstance();
        assertSame(r1, r2);
        System.out.println(r1.name());
    }

    @Test
    public void enums() {
        Resource r1 = EnumSingleton.INSTANCE.getResource();
        Resource r2 = EnumSingleton.INSTANCE.getResource();
        assertSame(r1, r2);
        System.out.println(r1.name());
    }
}
