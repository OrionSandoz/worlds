package com.example.hexc;

import com.example.hexa.AnHexAOperation;
import com.example.system.AnyOperationExecutor;

public class HexCExternalWorldAdapter implements ExternalWorldAdapter {

    private final AnyOperationExecutor anyOperationExecutor;
    
    public HexCExternalWorldAdapter(AnyOperationExecutor anyOperationExecutor){
        this.anyOperationExecutor = anyOperationExecutor;
    }

    @Override
    public String getValueFromExternalWorld() {

        AnHexAOperation anHexAOperation = new AnHexAOperation();
        anyOperationExecutor.executeOperation(anHexAOperation);

        return anHexAOperation.result();
    }
    
}
