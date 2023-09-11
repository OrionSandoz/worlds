package io.orisan.worlds.world_C;

import io.orisan.worlds.system.AnyOperationExecutor;
import io.orisan.worlds.world_A.pub.AWorldAOperation;
import io.orisan.worlds.world_C.pub.ExternalWorldAdapter;

public class WorldCExternalWorldAdapter implements ExternalWorldAdapter {

    private final AnyOperationExecutor anyOperationExecutor;
    
    public WorldCExternalWorldAdapter(AnyOperationExecutor anyOperationExecutor){
        this.anyOperationExecutor = anyOperationExecutor;
    }

    @Override
    public String getValueFromExternalWorld() {

        AWorldAOperation worldAOperation = new AWorldAOperation();
        anyOperationExecutor.executeOperation(worldAOperation);

        return worldAOperation.result();
    }
    
}
