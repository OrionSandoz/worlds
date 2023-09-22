
Proposing a solution to address following recurent pain-points as
- Coupling
- Functionality testability


Concept
- Based on Hexagonal architecture defined by Alistair Cockburn

- Clarifying some concepts
    - World : a functional unit that manages fully its business processes without knowing anyting about the external world. Typicaly an Hexagon as defined by Alistair Cockburn. A functional unit be built with several classes   
    - Operation : a command proposed by a World used to interact with it. 
    - Adapter : implements interfaces imposed by a World
    - Client : uses the Operations proposed by a World
    

- A world defines adapter interfaces to interact with the external world. 
    - A concrete adapter implements that interface and defines how it concretely does the job in the context of a given application. 

- Note about ports and adapters  
    - In a ports&adapters, or Hexagonal language the concepts of ports and adapters is not clearely defined. 
    When you implement a method in the an hexagon needs to communicate with the external world, i.e. to get some data from a database, you use the Adapter interface defined by the World for that purpose.
    Then, in the application you use the world you define the concrete implementation of that adapter. 
    It doesn't make sense to call the latter an Adapter, and the former a Port.
    It makes more sense to consider the Ports as the public methods offered by the World to communicate with it, and Adapter the Adapter interface imposed by the World. 
    In the World based architecture ports are moved to the Operations
    - Clients uses Operations, Operations uses their dedicated World, the World uses its Adapters, the concrete implementation of the Adapters does the job in the context of the application by accessing to a database or using another Operation or any other thing it must do.

    - Moving ports to Operations level 
        - By asking to Client to use Operation and not the World public methods you have more room for refactoring the World public methods without affecting the Client. The Operations internal implementation, fully part of the World, will have to be refactored as well but the Client won't have to adapt anything his side.    
         

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
    - Just decide if the responsibility is part of the functional domain covered by the World or not
    - An Hexagon is external world agnostic of
        - how to get info not held by itself
        - in which world the functionnaliy is integrated (framework, infrastructure, technology) 
            - how the functionaliy is accessed (command line, http, event, etc ...)
            - connectics to the infrastructure (datasources, apis, messaging systems, etc ...)
            - application level framework choice (ie Spring)  
    - Any consideration out of the strict functionnality covered by Hexagon is outside of the Hexagon and let to the responsibility of the Client or Adapters implementations specific to the application that knows the context in which the functionnality is integrated


Todo
- No added value brought by hexagon specific OperationExecutor : systematic use of AnyOperationExecutor fed with Hexagons instances the application uses
    - Very simple cases could also use only the hexagon and it's operations. Just call operation's execute method giving the hexagon instance 
        - This approach can also be useful if you implement stateful hexagons where you want to execute the operation agains a specific instance of the hexagon. 
            - Not recommended approach, may be a better option to keep the state out of the hexagon itself and keeping the hexagon stateless : you don't can't/want/need to know all the considerations that could go with managing a state (cache, persistence, other application features like monitoring, etc ...)
- Maybe won't keep the PostOperation. Too temptating to address some non-functional requirements like auditing using it. And no way to have safetyness by unit tests. You can be ok in the test but you can forget to set the PostOperation in the OperationExecutor instanciated at the application level. A pure World approach ensures this. Auditing requirements could be addressed explicitely by the Operations that needs to be audited. Could implement some logging for debug purpose like ie. Operation execution time     

