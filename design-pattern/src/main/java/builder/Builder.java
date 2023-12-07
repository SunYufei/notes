package builder;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Builder<T> {
    /**
     * 构造函数
     */
    private final Supplier<T> constructor;
    /**
     * 初始化类属性
     */
    private Consumer<T> headConsumer = it -> {
    };

    private Builder(Supplier<T> constructor) {
        this.constructor = constructor;
    }

    public static <T> Builder<T> of(Supplier<T> constructor) {
        Objects.requireNonNull(constructor);
        return new Builder<>(constructor);
    }

    /**
     * setter 方法
     */
    public <U> Builder<T> with(BiConsumer<T, U> setter, U value) {
        Objects.requireNonNull(setter);
        headConsumer = headConsumer.andThen(instance -> setter.accept(instance, value));
        return this;
    }

    /**
     * setter 方法，带参数校验
     */
    public <U> Builder<T> with(BiConsumer<T, U> setter, U value, Predicate<U> predictor) {
        Objects.requireNonNull(predictor);
        if (!predictor.test(value)) {
            throw new IllegalArgumentException(value + " is invalid");
        }
        return with(setter, value);
    }

    public T build() {
        // 调用构造函数生成实例
        T instance = constructor.get();
        // 调用 setter 构造实例
        headConsumer.accept(instance);
        // 返回构造好的实例
        return instance;
    }
}
