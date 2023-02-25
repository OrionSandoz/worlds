package com.example.hexc;

import org.junit.Assert;
import org.junit.Test;

import com.example.hexa.internal.HexA;
import com.example.hexc.internal.HexC;
import com.example.system.AnyOperationExecutor;

public class HexCTest {

    @Test
    public void testHexC(){

        AnyOperationExecutor anyOperationExecutor = new AnyOperationExecutor();
        
        HexA hexA = new HexA();
        anyOperationExecutor.addHexagon(hexA);

        HexCExternalWorldAdapter worldAdapter = new HexCExternalWorldAdapter(anyOperationExecutor);
        HexC hexC = new HexC(worldAdapter);
        anyOperationExecutor.addHexagon(hexC);

        AnHexCOperation anHexCOperation = new AnHexCOperation();
        
        anyOperationExecutor.executeOperation(anHexCOperation);

        String result = anHexCOperation.result();

        Assert.assertEquals("HexC : HexA did something", result);

    }
    
}
