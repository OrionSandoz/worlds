package com.example.hexb;

import com.example.hexb.internal.HexB;
import com.example.hexb.internal.HexBOperation;
import com.example.system.OperationExecutor;

public class HexBOperationsExecutor implements OperationExecutor<HexBOperation> {

    private final HexB hexB;

    public HexBOperationsExecutor() {
        this.hexB = new HexB();
    }

    public void executeOperation(HexBOperation operation) {
        operation.execute(hexB);
    }

}
