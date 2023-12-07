package singleton;

public final class HungrySingleton {
    private static final Resource INSTANCE = new Resource("hungry");

    public static Resource getInstance() {
        return INSTANCE;
    }

    private HungrySingleton() {
    }
}
