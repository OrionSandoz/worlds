
Proposing a solution to address following recurent pain-points as
- Coupling
- Functionality testability

Expected benefits
- Breaks coupling issues
    - The client is not coupled to the Hexagon's internal implementation
    - The client is even not coupled to the Hexagon's interface
    - The client doesn't even know the existence of the Hexagon
    - The client only knows Operations and the AnyOperationExecutor
    - In the respect of the Hexagonal architecture, there's no dependency between Hexagons 
- Stronger functionnality testing 
    - Unit testing for its optimal execution time : quickest feedback 
    - Unit tests as TDD, BDD, DDD and other DDs together (a whole subject by itself ...)
    - The unit is not the class but the Hexagon with all it's involved classes 
        - The test is a client of the Hexagon as any other client 
        - You can use a unit test on an internal class when implementing a specific method, but don't keep that test. Integrate the hexagons behaviour change in the hexagons test, showing when this new implementation TOCONTINUE
- Clarify responsibility placing in code 
    - Just decide if the responsibility is part of the functional domain covered by the Hexagon or not
    - An Hexagon is external world agnostic of
        - how to get info not held by itself
        - in which world the functionnaliy is integrated (framework, infrastructure, technology) 
            - how the functionaliy is accessed (command line, http, event, etc ...)
            - connectics to the infrastructure (datasources, apis, messaging systems, etc ...)
            - application level framework choice (ie Spring)  
    - Any condideration out of the strict functionnality covered by Hexagon is outside of the Hexagon and let to the responsibility of the client or adapters implementations specific to the application that knows the context in which the functionnality is integrated


Todo
- No added value brought by hexagon's specific OperationExecutor : systematic use of AnyOperationExecutor fed with  Hexagons instances the application uses
    - Very simple cases could also use only the hexagon and it's operations. Just call operation's execute method giving the hexagon instance 
        - This approach can also be useful if you implement stateful hexagons where you want to execute the operation agains a specific instance of the hexagon. 
            - Not recommended approach, may be a better option to keep the state out of the hexagon itself and keeping the hexagon stateless : you don't can't/want/need to know all the considerations that could go with managing a state (cache, persistence, other application features like monitoring, etc ...)

