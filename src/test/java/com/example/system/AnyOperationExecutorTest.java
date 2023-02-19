package com.example.system;

import org.junit.Assert;
import org.junit.Test;

import com.example.hexa.AnHexAOperation;
import com.example.hexa.internal.HexA;
import com.example.hexb.AnHexBOperation;
import com.example.hexb.internal.HexB;

public class AnyOperationExecutorTest {
    
    @Test
    public void testWithHexAOperation(){
        AnyOperationExecutor anyOperationExecutor = new AnyOperationExecutor();
        anyOperationExecutor.addHexagon(new HexA());
        anyOperationExecutor.addHexagon(new HexB());

        AnHexAOperation hexAOperation = new AnHexAOperation();
        anyOperationExecutor.executeOperation(hexAOperation);   
        Assert.assertEquals("HexA did something", hexAOperation.result());

        Long parameter = 1234L;
        AnHexBOperation hexBOperation = new AnHexBOperation(parameter);
        anyOperationExecutor.executeOperation(hexBOperation);
        Assert.assertEquals(new Long(parameter * 10), hexBOperation.result());


        AnHexAOperation otherHexAOperation = new AnHexAOperation();
        anyOperationExecutor.executeOperation(otherHexAOperation);   
        Assert.assertEquals("HexA did something", otherHexAOperation.result());

        parameter = 6789L;
        AnHexBOperation otherHexBOperation = new AnHexBOperation(parameter);
        anyOperationExecutor.executeOperation(otherHexBOperation);
        Assert.assertEquals(new Long(parameter * 10), otherHexBOperation.result());
    }

    @Test(expected = RuntimeException.class)
    public void notDeclaredHexagon(){
        AnyOperationExecutor anyOperationExecutor = new AnyOperationExecutor();

        AnHexAOperation hexAOperation = new AnHexAOperation();
        anyOperationExecutor.executeOperation(hexAOperation);   

    }
}
