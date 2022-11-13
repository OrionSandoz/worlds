package com.example.hexa;

import com.example.hexa.internal.HexA;
import com.example.hexa.internal.HexAOperation;
import com.example.system.OperationExecutor;

public class HexAOperationsExecutor implements OperationExecutor<HexAOperation> {

    private final HexA hexA;

    public HexAOperationsExecutor() {
        this.hexA = new HexA();
    }

    public void executeOperation(HexAOperation operation) {
        operation.execute(hexA);
    }

}
