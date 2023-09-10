package io.orisan.world_A.pub;

import io.orisan.world_A.internal.WorldA;
import io.orisan.world_A.internal.WorldAOperation;
import io.orisan.worlds.system.OperationExecutor;

public class WorldAOperationsExecutor implements OperationExecutor<WorldAOperation> {

    private final WorldA worldA;

    public WorldAOperationsExecutor() {
        this.worldA = new WorldA();
    }

    public void executeOperation(WorldAOperation operation) {
        operation.execute(worldA);
    }

}
