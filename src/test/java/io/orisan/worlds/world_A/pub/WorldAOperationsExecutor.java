package io.orisan.worlds.world_A.pub;

import io.orisan.worlds.system.OperationExecutor;
import io.orisan.worlds.world_A.internal.WorldA;
import io.orisan.worlds.world_A.internal.WorldAOperation;

public class WorldAOperationsExecutor implements OperationExecutor<WorldAOperation> {

    private final WorldA worldA;

    public WorldAOperationsExecutor() {
        this.worldA = new WorldA();
    }

    public void executeOperation(WorldAOperation operation) {
        operation.execute(worldA);
    }

}
