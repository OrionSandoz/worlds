package io.orisan.worlds.system;

public interface AroundExecution {
    boolean accept(Operation<?> operation);
    void before(Operation<?> operation);
    void after(Operation<?> operation);
    void getInstance(AroundExecution aroundExecution);
}
