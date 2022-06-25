package com.example.system;

public interface Operation<HEXAGON, OPERATION_RESULT> {
    void execute(HEXAGON hex);
    OPERATION_RESULT result();
}


