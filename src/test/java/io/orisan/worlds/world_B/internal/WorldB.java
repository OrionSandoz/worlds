package io.orisan.worlds.world_B.internal;

import io.orisan.worlds.system.World;

public class WorldB implements World {

    public WorldB() {
    }

    public Long doSomethingElse(Long inputParameter){
        return inputParameter * 10;
    }  
}
