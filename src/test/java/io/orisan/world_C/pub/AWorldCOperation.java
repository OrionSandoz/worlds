package io.orisan.world_C.pub;

import io.orisan.world_C.internal.WorldC;
import io.orisan.world_C.internal.WorldCOperation;

public class AWorldCOperation implements WorldCOperation {

    private String result = "";

    public String result(){
        return result;
    }

    @Override
    public void execute(WorldC hex) {
        result = hex.doWorldCThing();
    }
    
}
