package modules.Lambdas.demos.demo3;

@FunctionalInterface
public interface Operation<T> {

    T operate(T value1, T value2);
}
