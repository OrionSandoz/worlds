package com.example.hexa;

import com.example.hexa.internal.HexA;
import com.example.hexa.internal.HexAOperation;

public class AnHexAOperation implements HexAOperation {

    String result = "NO RESULT YET";

    @Override
    public void execute(HexA hexA) {
        result = hexA.doSomething();
    }

    public String result() {
        return result;
    }
    
}
