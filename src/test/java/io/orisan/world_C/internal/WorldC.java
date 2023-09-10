package io.orisan.world_C.internal;

import io.orisan.world_C.pub.ExternalWorldAdapter;
import io.orisan.worlds.system.World;

public class WorldC implements World {

    private final ExternalWorldAdapter externalWorldAdapter;
    
    public WorldC(ExternalWorldAdapter externalWorldAdapter){
        this.externalWorldAdapter = externalWorldAdapter;
    }

    public String doWorldCThing(){
        return "WorldC : " + externalWorldAdapter.getValueFromExternalWorld();
    }


    
}
