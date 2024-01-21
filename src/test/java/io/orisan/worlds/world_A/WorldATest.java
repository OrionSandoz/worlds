package io.orisan.worlds.world_A;

import org.junit.Assert;
import org.junit.Test;

import io.orisan.worlds.system.AnyOperationExecutor;
import io.orisan.worlds.world_A.internal.WorldA;
import io.orisan.worlds.world_A.pub.AWorldAOperation;

public class WorldATest {

    @Test
    public void testWorldA(){
        AnyOperationExecutor executor = new AnyOperationExecutor();
        executor.withWorld(new WorldA());

        AWorldAOperation operation = new AWorldAOperation();
        executor.executeOperation(operation);

        Assert.assertEquals("WorldA did something", operation.result());
    }
}
