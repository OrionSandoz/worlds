[![Maven Central](https://img.shields.io/maven-central/v/io.orisan/worlds.svg)](https://search.maven.org/artifact/io.orisan/worlds)

# Worlds
**io.orisan.worlds** is a tiny framework putting your functional domains into action

## Keys
    World : a functional unit that manages fully its business processes without knowing anyting about the external world. Typicaly an Hexagon as defined by Alistair Cockburn. A functional unit be built with several classes
    
    Operation : a command proposed by a World used to interact with it.
    
    Adapter : implements interfaces imposed by a World
    
    Client : uses the Operations proposed by a World

    A World defines adapter interfaces to interact with the external world. A concrete adapter implements that interface and defines how it concretely does the job in the context of a given application. 

## Create your fancy World

### Implement your fancy World
```java
public class FancyWorld implements World {

    private final ExternalWorldAdapter externalWorldAdapter;
    
    public FancyWorld(ExternalWorldAdapter externalWorldAdapter){
        this.externalWorldAdapter = externalWorldAdapter;
    }

    public String doFancyWorldThing(){
        return "Fancy World says " + externalWorldAdapter.getValueFromExternalWorld();
    }
}
```

Your fancy World may need to communicate with the external world
```java
public interface ExternalWorldAdapter {
    
    String getValueFromExternalWorld();
}
```

### Define an Operation interface for your FancyWorld Operations 
```java
public interface FancyWorldOperation extends Operation<FancyWorld> {
}
```

### Implement an Operation 
```java
public class DoFancyThing implements FancyWorldOperation {

    private String result = "";

    public String result(){
        return result;
    }

    @Override
    public void execute(FancyWorld hex) {
        result = hex.doFancyWorldThing();
    }
    
}
```



## Use four fancy World within an application

### Add Maven dependecy to your pom.xml
```
<dependency>
    <groupId>io.orisan</groupId>
    <artifactId>worlds</artifactId>
</dependency>
```

### Define the concrete implementation of ExternalWorldAdapter interface
```java
public class MyExternalWorldAdapter implements ExternalWorldAdapter {

    @Override
    public String getValueFromExternalWorld() {
        return "foo";
    }
    
}
```

### Instanciate your Fancy World, instanciate the OperationExecutor and declare that your Fancy World exists 
This is typicaly done in a Configuration class returning the operationExecutor. 
ie in a SpringBoot Configuration class
```java
@Bean
public AnyOperationExecutor operationExecutor(){
    AnyOperationExecutor anyOperationExecutor = new AnyOperationExecutor();

    MyExternalWorldAdapter worldAdapter = new MyExternalWorldAdapter(anyOperationExecutor);
    FancyWorld fancyWorld = new FancyWorld(worldAdapter);

    anyOperationExecutor.addWorld(fancyWorld);

    return anyOperationExecutor;
}
```

### Use operations provided by FancyWorld anywhere in your application
Inject the AnyOperationExecutor instance anywhere you need to interact with functional domains you're using within your application 

```java
    DoFancyThing doFancyThing = new DoFancyThing();
        
    operationExecutor.executeOperation(doFancyThing);

    String result = doFancyThing.result();  // "Fancy World says foo"
```


## Motivation
### Promoting usage of Hexagonal Architecture.
In my experience that software architecture style provides huge benefits for any kind of application and opens interesting oportunities at the information system level.

Specific section comming soon ...

### Bring an additional touch to Hexgonal Architecture
- Offer an out of the box way to interact with functional domains in the most possible decoupled way 
- Solve the mutual dependency issue

## Benefits
- Solves the mutual dependency issue when two functional domains have to bidirectional communication needs.
- Gives more room for domain refactoring. The client doesn't use the domain interface directly anymore but uses domain's operations instead, so you are able to change the domain's interace without impacting the client.
- You only inject the Operation Executor all way round.
- Give more meaningful interaction with the functional domain to the Client. As the Operation holds the input and the domain's output you can propose methods to access the result a more meaningful and with a more added value way that just giving back raw data.
- Losens a bit more the coupling between the application and the functional domains
- The client only knows Operations provided by the functional domains and the AnyOperationExecutor
