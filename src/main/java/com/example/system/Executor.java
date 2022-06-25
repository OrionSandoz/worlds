package com.example.system;

public interface Executor<HEXAGON, OPERATION extends Operation<HEXAGON, OPERATION_RESULT>, OPERATION_RESULT> {
 
    OPERATION_RESULT executeOperation(OPERATION operation); 


}
