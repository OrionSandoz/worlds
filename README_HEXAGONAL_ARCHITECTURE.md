# About Hexagonal Architecture 
In my experience that architecture style provides huge benefits for any application as long as it applies a rule. Could be out of interest for writing a pure CRUD application, but who does write pure CRUD applications today ?

IMHO the reason it has not been widely adopted up to this point is more due to 
   - A lack of clarity on how to concretely implement it.  
   - Developers habits that tend to do *as usual* and finaly accepts to deal with the reccuring painpoints as something you just have to live with, hoping the next trendy language or framework will finaly solve it.   

### Let's try to clarify
Hexagonal Architecture promotes the usage of an artefact [*the hexagon*] that manages to solve problems of a specific functional domain [*the problem domain*]

In the general usage people tend to name a domain implementation an *hexagon*, by extension of the architecture style name I guess. Naming it a *functionnal domain* is more meaningful to me so I'll use it there.  

#### General rules
1. A given functional domain doesn't know anything about the context 
- how the functionality is accessed
- what data model is exposed by the application 
- what data model is used for persistency
- how the data is accessed or persisted 

2. A functional domain has no external dependecies, it masters everything that is in its hands and imposes its rules. The only exception is the dependencies on libraries providing language extensions like ie Apache Commons

<p align="center">
  <img src="./docs/hexagon-dependency-direction.svg" />
</p>


3. Functionalities provided by a functional domain are accessed by *clients*. *Clients **uses** the domain's interface.*

<p align="center">
  <img src="./docs/client-uses-hexagon.svg" />
</p>

4. The functional domain uses *adapters* to communicate with the external world. Adapters are typically interfaces owned by the domain. The application using the domain [*the context*] must provide a concrete implementation of these adapters. *An adapter **implements** the adapter interfaces of the domain.* 
It specifies ie how to concretely access the data from 
- another functional domain 
- a database using SQL queries   
- an http call to an external service 
- a file 
- or any other mean to get the required data

<p align="center">
  <img src="./docs/hexagon-uses-adapters.svg" />
</p>

The application then brings the concrete adapter implementation that fits the context. 

<p align="center">
  <img src="./docs/application-brings-adapter-concrete-implementation.svg" />
</p>


The concrete adapter implementation is given to the functional domain at creation time through its constructor.  



## Reduce coupling
In a layer based architecture dependency flow looks like this
<p align="center">
  <img src="./docs/layered-dependency-flow.svg" />
</p>

It's all fine until a common component is used by two different flows
<p align="center">
  <img src="./docs/layered-coupled-flow.svg" />
</p>

In an hexagonal architecture the dependency flow will be
<p align="center">
  <img src="./docs/hexagonal-dependency-flow.svg" />
</p>


## Benefits

### Testability
    Testing against an hexagon gives the ability to test all the code involved at once, as a whole. This ensures he functionality is working correctly. 
    When you a test at class level, a given class can work perfectly well, and another one too, but can not work well once put together in action. And this can be a nightmare when refactoring as these tests are coupled with these classes interfaces. If you change the interface for a given reason, you will have to adapt the test accordingly. It means you changed the test and the implementation the same time, and what ensures you didn't messed up the test when adapting it ? The test cannot play its role at the most important moment it is done for: ensure my application still works the same after having changed the implemenation ... of course you can ensure that by implementing integration tests but tough, coupled to the technology you're using, needs infrastructure mocking strategies and slow to run.

    By it's nature an hexagon is always easy to test as you can mock everything that is around just contextual. 
    The tests can be longer if your hexagon implements a large and complex functional domain (it actually just reflects that your functional domain is a complex one), but at the end you will end up writing less tests that gives much more confidence.
    
    It also tends to drive you to write your tests with a more functional view of the problem. 
### Responsibility placing
    When working in typical layered application, you sometime don't find easily have to place a given responsibility. A responsibility that will for sure have a functional impact. In the controler ? a manager ? a service ? a helper ? even in the view or the data layer ?

    Just place it in the hexagon in charge of the functionality. Somewhere, anywhere, but in it.

    At the end, only infrastructure interfaces and data mappings will remain at the application level. All the added value of your application resides in the hexagons  
### Reduces complexity
    Having few single components to think about implies less cognitive load than hundreds of single classes to manage
### Reduces coupling 
    In the respect of the Hexagonal architecture, there's no direct dependency between Hexagons and between Hexagons and the application
### Stronger functionnality testing 
    - Unit testing for its optimal execution time : quickest feedback 
    - Unit tests as TDD, BDD, DDD and other DDs together (a whole subject by itself ...)
    - The unit is not the class but the Hexagon. With all it's involved classes it constitues a single functional unit. 
        - The test is a client of the Hexagon as any other client 
        - If needed you can of course use a unit test on an internal class if it helps implementing a specific method, but don't keep that test as it will be too tightly coupled to the implementation. 
### Clarify responsibility placing in code 
    - Decide if the responsibility is part of the functional domain covered by the Hexagon or not
    - An Hexagon is external world agnostic of
        - how to get info not held by itself
        - in which world the functionnaliy is integrated (framework, infrastructure, technology) 
            - how the functionaliy is accessed (command line, http, event, etc ...)
            - connectics to the infrastructure (datasources, apis, messaging systems, etc ...)
            - application level framework choice (ie Spring)  
    - Any consideration out of the strict functionnality covered by Hexagon is outside of the Hexagon and let to the responsibility of the client or adapters implementations specific to the application that knows the context in which the functionnality is integrated
### Reduces the impact of implementation choice
    Techical choices or implementation details can strongly impact an application in terms of maintainability, testability or predictability if not suitable. Even well done, it can be pretty suitable at a given moment in the application life and can become a nightmare month or years later. By using an Hexagonal architecture your technical choices can affect only a given hexagon or the application itself but has less chance not spread everywhere

...



  

- Note about ports and adapters and Hexagonal architecture 
    - In a ports&adapters, or Hexagonal architecture the concepts of ports and adapters is not clearly defined. 
    When you implement a method in an hexagon that needs to communicate with the external world, i.e. to get some data from a database, you use the Adapter interface defined by the World for that purpose.
    Then, in the application you use the world, you define the concrete implementation of that adapter. 
    It doesn't make sense to call the latter an Adapter, and the former a Port.
    It makes more sense to consider the Ports as the public methods offered by the World to communicate with it, and Adapter the Adapter interface imposed by the World. 
    In the World based architecture ports are moved to the Operations
    - Clients uses Operations, Operations uses their dedicated World, the World uses its Adapters, the concrete implementation of the Adapters does the job in the context of the application by accessing to a database or using another Operation or any other thing it has to do.

    - Moving ports to Operations level 
        - By asking to Client to use Operation and not the World public methods you have more room for refactoring the World public methods without affecting the Client. The Operations internal implementation, fully part of the World, will have to be refactored as well but the Client won't have to adapt anything his side.    