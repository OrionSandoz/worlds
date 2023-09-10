package io.orisan.world_A;

import org.junit.Assert;
import org.junit.Test;

import io.orisan.world_A.pub.AWorldAOperation;
import io.orisan.world_A.pub.WorldAOperationsExecutor;

public class WorldATest {

    @Test
    public void testWorldA(){
        WorldAOperationsExecutor executor = new WorldAOperationsExecutor();

        AWorldAOperation operation = new AWorldAOperation();
        executor.executeOperation(operation);

        Assert.assertEquals("WorldA did something", operation.result());
    }
}
