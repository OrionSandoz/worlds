package io.orisan.worlds.world_B;

import org.junit.Assert;
import org.junit.Test;

import io.orisan.worlds.world_B.pub.AWorldBOperation;
import io.orisan.worlds.world_B.pub.WorldBOperationsExecutor;


public class WorldBTest {

    @Test
    public void testHexB(){
        WorldBOperationsExecutor executor = new WorldBOperationsExecutor();

        Long parameter = 1234L;
        AWorldBOperation operation = new AWorldBOperation(parameter);
        executor.executeOperation(operation);

        Assert.assertEquals(new Long(parameter * 10), operation.result());
    }
}
