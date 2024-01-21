package io.orisan.worlds.world_B.pub;

import io.orisan.worlds.world_B.internal.WorldB;
import io.orisan.worlds.world_B.internal.WorldBOperation;

public class AWorldBOperation implements WorldBOperation {

    public final Long parameter;
    
    Long result = -1L;
    
    public AWorldBOperation(Long parameter){
        this.parameter = parameter;
    }

    @Override
    public void execute(WorldB worldB) {
        result = worldB.doSomethingElse(parameter);
    }

    public Long result() {
        return result;
    }
    
}
