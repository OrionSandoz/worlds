package com.example.hexb;

import com.example.hexb.internal.HexB;
import com.example.hexb.internal.HexBOperation;

public class AnHexBOperation implements HexBOperation {

    Long result = -1L;
    
    Long parameter;
    public AnHexBOperation(Long parameter){
        this.parameter = parameter;
    }

    @Override
    public void execute(HexB hexB) {
        result = hexB.doSomethingElse(parameter);
    }

    public Long result() {
        return result;
    }
    
}
