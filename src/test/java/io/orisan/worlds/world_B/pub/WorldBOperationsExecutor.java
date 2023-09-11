package io.orisan.worlds.world_B.pub;

import io.orisan.worlds.system.OperationExecutor;
import io.orisan.worlds.world_B.internal.WorldB;
import io.orisan.worlds.world_B.internal.WorldBOperation;

public class WorldBOperationsExecutor implements OperationExecutor<WorldBOperation> {

    private final WorldB hexB;

    public WorldBOperationsExecutor() {
        this.hexB = new WorldB();
    }

    public void executeOperation(WorldBOperation operation) {
        operation.execute(hexB);
    }

}
