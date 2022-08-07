package com.example.hexa;

import org.junit.Assert;
import org.junit.Test;

public class HexATest {

    @Test
    public void testHexA(){
        HexAOperationsExecutor executor = new HexAOperationsExecutor();

        AnHexAOperation operation = new AnHexAOperation();
        executor.executeOperation(operation);

        Assert.assertEquals("HexA did something", operation.result());
    }
}
