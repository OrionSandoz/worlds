package com.example.hexc.internal;

import com.example.hexc.ExternalWorldAdapter;
import com.example.system.Hexagon;

public class HexC implements Hexagon {

    private final ExternalWorldAdapter externalWorldAdapter;
    
    public HexC(ExternalWorldAdapter externalWorldAdapter){
        this.externalWorldAdapter = externalWorldAdapter;
    }

    public String doHexcThing(){
        return "HexC : " + externalWorldAdapter.getValueFromExternalWorld();
    }


    
}
