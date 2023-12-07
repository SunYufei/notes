package singleton;

public final class LazySingleton {
    private static volatile Resource INSTANCE;

    public static synchronized Resource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Resource("lazy");
        }
        return INSTANCE;
    }

    public static Resource getInstanceV2() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Resource("lazy v2");
                }
            }
        }
        return INSTANCE;
    }

    private LazySingleton() {
    }
}
