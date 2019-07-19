package core.patterns.behavioral.strategy.transport;

public interface RestService<T> {
    void send(T value);
}
