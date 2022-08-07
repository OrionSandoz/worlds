package com.example.hexa;

import com.example.hexa.internal.Hexa;

public class AnHexAOperation implements HexAOperation<Hexa> {

    String result = "NO RESULT YET";

    @Override
    public void execute(Hexa hexA) {
        result = hexA.doSomething();
    }

    public String result() {
        return result;
    }
    
}
