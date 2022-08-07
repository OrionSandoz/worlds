package com.example.hexa;

import com.example.hexa.internal.Hexa;

public class HexAOperationsExecutor {

    private final Hexa hexA;

    public HexAOperationsExecutor() {
        this.hexA = new Hexa();
    }

    public void executeOperation(HexAOperation<Hexa> operation) {
        operation.execute(hexA);
    }

}
