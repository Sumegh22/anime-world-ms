# Microservices Notes

Why MicroServices ??..
---------
1. In monolithic architecture, multiple services are combined in 1 app.
2. So all have to be of single code base. multiple services have to be written in single prog language 
3. All services in single bundle , so change in 1 causes entire app to be redeployed
4. Failure to 1 lead to entire project down
5. Problem in scale
6. Cumbersome
------------------------------------


Microservices
-------------------
* Large App is divided into multiple independent services
* These communicate using RestApi communications
* This is highly scalable
* Each service can have different codebase
* Each service can have different database
* Handling microservice is complex

------------------------------------


Service Registry
-------------------
* A centralized location where all microservices of an application are registered against their name
* It keeps a record of each MS is pointed at which IP address
* Very useful to manage REST calls between services