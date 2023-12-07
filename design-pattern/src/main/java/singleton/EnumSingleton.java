package singleton;

public enum EnumSingleton {
    INSTANCE;

    private final Resource resource;

    EnumSingleton() {
        this.resource = new Resource("enum");
    }

    public Resource getResource() {
        return resource;
    }
}
