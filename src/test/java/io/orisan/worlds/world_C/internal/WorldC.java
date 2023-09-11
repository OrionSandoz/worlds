package io.orisan.worlds.world_C.internal;

import io.orisan.worlds.system.World;
import io.orisan.worlds.world_C.pub.ExternalWorldAdapter;

public class WorldC implements World {

    private final ExternalWorldAdapter externalWorldAdapter;
    
    public WorldC(ExternalWorldAdapter externalWorldAdapter){
        this.externalWorldAdapter = externalWorldAdapter;
    }

    public String doWorldCThing(){
        return "WorldC : " + externalWorldAdapter.getValueFromExternalWorld();
    }


    
}
