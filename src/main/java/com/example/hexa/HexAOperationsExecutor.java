package com.example.hexa;

import com.example.system.Executor;

public class HexAOperationsExecutor<OUTPUT_TYPE> 
    implements Executor<Hexa, HexAOperation<Hexa, HexAOperationResult<OUTPUT_TYPE>>, HexAOperationResult<OUTPUT_TYPE>> {

    private final Hexa hexA;

    public HexAOperationsExecutor() {
        this.hexA = new Hexa();
    }

    @Override
    public HexAOperationResult<OUTPUT_TYPE> executeOperation(
            HexAOperation<Hexa, HexAOperationResult<OUTPUT_TYPE>> operation) {
                operation.execute(hexA);
                return operation.result();
    }

}
