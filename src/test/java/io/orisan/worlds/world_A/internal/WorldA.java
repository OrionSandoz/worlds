package io.orisan.worlds.world_A.internal;

import io.orisan.worlds.system.World;

public class WorldA implements World {

    public WorldA() {
    }

    public String doSomething(){
        return this.getClass().getSimpleName() + " did something";
    }  
}
