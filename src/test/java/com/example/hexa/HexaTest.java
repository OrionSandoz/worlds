package com.example.hexa;

import org.junit.Assert;
import org.junit.Test;

public class HexaTest {

    @Test
    public void testHexa(){
        HexAOperationsExecutor<String> executor = new HexAOperationsExecutor<String>();

        AnHexAOperation operation = new AnHexAOperation();
        HexAOperationResult<String> operationResult = executor.executeOperation(operation);

        Assert.assertEquals("Hexa did something", operationResult.result());
    }
}
