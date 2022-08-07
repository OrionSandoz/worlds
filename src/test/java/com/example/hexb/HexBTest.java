package com.example.hexb;

import org.junit.Assert;
import org.junit.Test;


public class HexBTest {

    @Test
    public void testHexB(){
        HexBOperationsExecutor executor = new HexBOperationsExecutor();

        Long parameter = 1234L;
        AnHexBOperation operation = new AnHexBOperation(parameter);
        executor.executeOperation(operation);

        Assert.assertEquals(new Long(parameter * 10), operation.result());
    }
}
