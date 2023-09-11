package io.orisan.worlds.world_C;

import org.junit.Assert;
import org.junit.Test;

import io.orisan.worlds.system.AnyOperationExecutor;
import io.orisan.worlds.world_A.internal.WorldA;
import io.orisan.worlds.world_C.internal.WorldC;
import io.orisan.worlds.world_C.pub.AWorldCOperation;

public class WorldCTest {

    @Test
    public void testHexC(){

        AnyOperationExecutor anyOperationExecutor = new AnyOperationExecutor();
        
        WorldA worldA = new WorldA();
        anyOperationExecutor.addWorld(worldA);

        WorldCExternalWorldAdapter worldAdapter = new WorldCExternalWorldAdapter(anyOperationExecutor);
        WorldC worldC = new WorldC(worldAdapter);
        anyOperationExecutor.addWorld(worldC);

        AWorldCOperation aWorldCOperation = new AWorldCOperation();
        
        anyOperationExecutor.executeOperation(aWorldCOperation);

        String result = aWorldCOperation.result();

        Assert.assertEquals("WorldC : WorldA did something", result);

    }
    
}
