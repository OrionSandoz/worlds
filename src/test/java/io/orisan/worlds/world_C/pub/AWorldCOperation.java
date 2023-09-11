package io.orisan.worlds.world_C.pub;

import io.orisan.worlds.world_C.internal.WorldC;
import io.orisan.worlds.world_C.internal.WorldCOperation;

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
