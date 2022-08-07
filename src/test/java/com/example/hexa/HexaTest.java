package com.example.hexa;

import org.junit.Assert;
import org.junit.Test;

public class HexaTest {

    @Test
    public void testHexA(){
        HexAOperationsExecutor executor = new HexAOperationsExecutor();

        AnHexAOperation operation = new AnHexAOperation();
        executor.executeOperation(operation);

        Assert.assertEquals("Hexa did something", operation.result());
    }
}
