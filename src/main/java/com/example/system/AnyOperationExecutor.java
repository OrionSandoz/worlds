package com.example.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
public class AnyOperationExecutor implements OperationExecutor<Operation> {
    
    private final List<Hexagon> hexagons = new ArrayList<>();
    private final Map<String, Hexagon> hexagonByOperation = new HashMap<>();

    public void addHexagon(Hexagon hexagon){
        hexagons.add(hexagon);
    }

    public void executeOperation(Operation operation){
        if(alreadyLearnedToExecuteOperation(operation)){
            execute(operation, relatedHexagon(operation));
        } else {
            learnToExecuteOperation(operation);
        }
    }

    private boolean alreadyLearnedToExecuteOperation(Operation operation){
        return hexagonByOperation.containsKey(operationTypeIdentifier(operation));
    }

    private void learnToExecuteOperation(Operation operation) {
        String operationTypeIdentifier = operationTypeIdentifier(operation);

        boolean foundRelatedHexagon = false;
        for(Hexagon hexagon : hexagons){
            try {
                
                // try to check if execute method fits the hexagon
                try {
                    operation.getClass().getMethod("execute", hexagon.getClass());
                } catch (NoSuchMethodException e) {
                    // if execute method doesn't accept the haxagon as param, it's not the right hexagon 
                    System.out.println("NoSuchMethodException : " + e.getMessage());
                    continue;
                } catch (SecurityException e) {
                    // if system setup doesn't allow to check the method existence, just continue and give a chance for an execution to succeed
                    System.out.println("SecurityException : " + e.getMessage());
                }
                
                // if the operation execute method doesn't accept the hexagon as parameter, a classcast execption will occur
                execute(operation, hexagon);

                foundRelatedHexagon = true;
                hexagonByOperation.put(operationTypeIdentifier, hexagon);
                
                break;
            } catch (ClassCastException e){
                System.out.println("Unsuccesful try to execute " + operationTypeIdentifier + " with " + hexagon.getClass().getName());
            }
        }

        if(!foundRelatedHexagon){
            throw new RuntimeException("You probably forgot to add the appropriate hexagon for operation " + operationTypeIdentifier);
        }
    }

    private void execute(Operation operation, Hexagon hexagon){
        operation.execute(hexagon);
    }

    private Hexagon relatedHexagon(Operation operation){
        return hexagonByOperation.get(operationTypeIdentifier(operation));
    }

    private String operationTypeIdentifier(Operation operation) {
        return operation.getClass().getName();
    }
    
}
