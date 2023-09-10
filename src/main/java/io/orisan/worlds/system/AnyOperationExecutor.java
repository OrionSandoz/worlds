package io.orisan.worlds.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
public class AnyOperationExecutor implements OperationExecutor<Operation> {
    
    private final List<World> worlds = new ArrayList<>();
    private final Map<String, World> worldByOperation = new HashMap<>();

    public void addWorld(World world){
        worlds.add(world);
    }

    public void executeOperation(Operation operation){
        if(alreadyLearnedToExecuteOperation(operation)){
            execute(operation, relatedWorld(operation));
        } else {
            learnToExecuteOperation(operation);
        }
    }

    private boolean alreadyLearnedToExecuteOperation(Operation operation){
        return worldByOperation.containsKey(operationTypeIdentifier(operation));
    }

    private void learnToExecuteOperation(Operation operation) {
        String operationTypeIdentifier = operationTypeIdentifier(operation);

        boolean foundRelatedWorld = false;
        for(World world : worlds){
            try {
                
                // try to check if execute method fits the hexagon
                try {
                    operation.getClass().getMethod("execute", world.getClass());
                } catch (NoSuchMethodException e) {
                    // if execute method doesn't accept the haxagon as param, it's not the right hexagon 
                    System.out.println("NoSuchMethodException : " + e.getMessage());
                    continue;
                } catch (SecurityException e) {
                    // if system setup doesn't allow to check the method existence, just continue and give a chance for an execution to succeed
                    System.out.println("SecurityException : " + e.getMessage());
                }
                
                // if the operation execute method doesn't accept the hexagon as parameter, a classcast execption will occur
                execute(operation, world);

                foundRelatedWorld = true;
                worldByOperation.put(operationTypeIdentifier, world);
                
                break;
            } catch (ClassCastException e){
                System.out.println("Unsuccesful try to execute " + operationTypeIdentifier + " with " + world.getClass().getName());
            }
        }

        if(!foundRelatedWorld){
            throw new RuntimeException("You probably forgot to add the appropriate World for operation " + operationTypeIdentifier);
        }
    }

    private void execute(Operation operation, World world){
        operation.execute(world);
    }

    private World relatedWorld(Operation operation){
        return worldByOperation.get(operationTypeIdentifier(operation));
    }

    private String operationTypeIdentifier(Operation operation) {
        return operation.getClass().getName();
    }
    
}
