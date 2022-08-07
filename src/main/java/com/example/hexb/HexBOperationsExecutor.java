package com.example.hexb;

import com.example.hexb.internal.HexB;
import com.example.hexb.internal.HexBOperation;
import com.example.system.HexagonExecutor;

public class HexBOperationsExecutor implements HexagonExecutor<HexBOperation> {

    private final HexB hexB;

    public HexBOperationsExecutor() {
        this.hexB = new HexB();
    }

    public void executeOperation(HexBOperation operation) {
        operation.execute(hexB);
    }

}
