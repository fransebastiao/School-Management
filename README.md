#School Management System

---


##Uml diagram for School management project

---

![](uml/schoolmanagemenruml.png)

##Brief description
This system is responsible for the automation of tasks that take place in managing different school departments.
With the aim of implementing some knowledge of domain driven design in spring boot applications using restful webservices.


##Composition of the system
This system is composed by API, rest controllers, factory, domain, repository and services packages, 
and inside each package there are the respective classes with its attributes and methods.


##Identified flaws in the uml and system implementation
The group analyzed that this diagram has tightly coupled relationships, which reduced the flexibility of the code.
Some of the interfaces are highly dependent on each other, changing one object requires changes to another number of objects, it is more difficult to reuse and test some classes because they are dependent on other classes,
which is not good programming.


##Our reflection for improvement
An advice of what can be done to minimize the system's complexity is not using tightly coupled interdependencies

The relationships between entities shouldn't be highly dependent on another entity because if one test fails the whole system stops

Loosely coupling the interdependencies between system components would help reduce the risk that changes to one component would require changes to any other component and increase the flexibility of the system.
This way is easier for adopting changes along the way.

In small applications is easier to identify and handle changes because there is a low chance of missing things, but in larger application is harder to manage every single change in the system.