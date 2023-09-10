package io.orisan.world_A.pub;

import io.orisan.world_A.internal.WorldA;
import io.orisan.world_A.internal.WorldAOperation;

public class AWorldAOperation implements WorldAOperation {

    String result = "NO RESULT YET";

    @Override
    public void execute(WorldA worldA) {
        result = worldA.doSomething();
    }

    public String result() {
        return result;
    }
    
}
