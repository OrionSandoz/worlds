package com.example.hexa.internal;

import com.example.system.Hexagon;

public class HexA implements Hexagon {

    public HexA() {
    }

    public String doSomething(){
        return this.getClass().getSimpleName() + " did something";
    }  
}
