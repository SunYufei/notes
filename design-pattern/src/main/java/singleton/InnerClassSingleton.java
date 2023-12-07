package singleton;

public final class InnerClassSingleton {
    public static Resource getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final Resource INSTANCE = new Resource("inner class");
    }

    private InnerClassSingleton() {
    }
}
