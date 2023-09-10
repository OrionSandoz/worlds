package io.orisan.world_B.pub;

import io.orisan.world_B.internal.WorldB;
import io.orisan.world_B.internal.WorldBOperation;
import io.orisan.worlds.system.OperationExecutor;

public class WorldBOperationsExecutor implements OperationExecutor<WorldBOperation> {

    private final WorldB hexB;

    public WorldBOperationsExecutor() {
        this.hexB = new WorldB();
    }

    public void executeOperation(WorldBOperation operation) {
        operation.execute(hexB);
    }

}
