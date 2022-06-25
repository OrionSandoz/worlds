package com.example.hexa;


public class AnHexAOperation implements HexAOperation<Hexa, HexAOperationResult<String>> {

    String result = "NAZE...";

    @Override
    public void execute(Hexa hexA) {
        result = hexA.doSomething();
    }

    @Override
    public HexAOperationResult<String> result() {
        return new HexAOperationResult<String>() {

            @Override
            public String result() {
                return result;
            }
            
        };
    }
    
}
