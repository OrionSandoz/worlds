package io.orisan.worlds.system;

public interface PostExecution {

    boolean accept(Operation<?> operation);
    void execute(Operation<?> operation);

}
