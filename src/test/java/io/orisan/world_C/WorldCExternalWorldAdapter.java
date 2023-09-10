package io.orisan.world_C;

import io.orisan.world_A.pub.AWorldAOperation;
import io.orisan.world_C.pub.ExternalWorldAdapter;
import io.orisan.worlds.system.AnyOperationExecutor;

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
