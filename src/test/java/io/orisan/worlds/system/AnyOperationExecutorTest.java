package io.orisan.worlds.system;

import org.junit.Assert;
import org.junit.Test;

import io.orisan.worlds.system.AnyOperationExecutor;
import io.orisan.worlds.world_A.internal.WorldA;
import io.orisan.worlds.world_A.pub.AWorldAOperation;
import io.orisan.worlds.world_B.internal.WorldB;
import io.orisan.worlds.world_B.pub.AWorldBOperation;

public class AnyOperationExecutorTest {
    
    @Test
    public void testWithHexAOperation(){
        AnyOperationExecutor anyOperationExecutor = new AnyOperationExecutor();
        anyOperationExecutor.addWorld(new WorldA());
        anyOperationExecutor.addWorld(new WorldB());

        AWorldAOperation worldAOperation = new AWorldAOperation();
        anyOperationExecutor.executeOperation(worldAOperation);   
        Assert.assertEquals("WorldA did something", worldAOperation.result());

        Long parameter = 1234L;
        AWorldBOperation worldBOperation = new AWorldBOperation(parameter);
        anyOperationExecutor.executeOperation(worldBOperation);
        Assert.assertEquals(new Long(parameter * 10), worldBOperation.result());


        AWorldAOperation otherWorldAOperation = new AWorldAOperation();
        anyOperationExecutor.executeOperation(otherWorldAOperation);   
        Assert.assertEquals("WorldA did something", otherWorldAOperation.result());

        parameter = 6789L;
        AWorldBOperation otherWorldBOperation = new AWorldBOperation(parameter);
        anyOperationExecutor.executeOperation(otherWorldBOperation);
        Assert.assertEquals(new Long(parameter * 10), otherWorldBOperation.result());
    }

    @Test(expected = RuntimeException.class)
    public void notDeclaredWorld(){
        AnyOperationExecutor anyOperationExecutor = new AnyOperationExecutor();

        AWorldAOperation hexAOperation = new AWorldAOperation();
        anyOperationExecutor.executeOperation(hexAOperation);   

    }
}
