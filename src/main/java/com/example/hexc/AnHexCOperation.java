package com.example.hexc;

import com.example.hexc.internal.HexC;
import com.example.hexc.internal.HexCOperation;

public class AnHexCOperation implements HexCOperation {

    private String result = "";

    public String result(){
        return result;
    }

    @Override
    public void execute(HexC hex) {
        result = hex.doHexcThing();
    }
    
}
