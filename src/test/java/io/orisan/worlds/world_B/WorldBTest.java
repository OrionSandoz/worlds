package io.orisan.worlds.world_B;

import org.junit.Assert;
import org.junit.Test;

import io.orisan.worlds.system.AnyOperationExecutor;
import io.orisan.worlds.world_B.internal.WorldB;
import io.orisan.worlds.world_B.pub.AWorldBOperation;


public class WorldBTest {

    @Test
    public void testHexB(){
        AnyOperationExecutor executor = new AnyOperationExecutor();
        executor.withWorld(new WorldB());

        Long parameter = 1234L;
        AWorldBOperation operation = new AWorldBOperation(parameter);
        executor.executeOperation(operation);

        Assert.assertEquals(new Long(parameter * 10), operation.result());
    }
}
