# SpringBootDemo

This demo  contains several services of the Health Portal Microservices-based Spring Boot project. Following are the details:

The doctors microservice  manages the information about the doctors. This service provides create, read, update, and delete (CRUD) operations. 
.
The patient microservice stores the data of the patient. It allows the end user to perform CRUD operations on patient entities.

The appointment microservice can accept new appointment by using the the patient microservice and doctor microservices.
This makes use of the doctor service and patient service to perform CRUD operations on appointment. It will leverage doctor searching and its associated timeslot lookup & allocation based on the timeslot availability for a specified duration of time. It creates a relationship between the doctor/timeslot and the patient.

Spring Cloud and Netflix Eureka were used for service registration and discovery. Thus, all the other microservices registered with Eureka. 

Zuul for intelligent routing, to manage all the iternal requests , forwarding external calls to the correct microservice.

Ribbon forload balancing, that each microservice can be scaled independently of the other microservices.

Hystrix for circuit breaker, ensure the failure of one microservice does not cause other microservices to fail as well.

Auth for authentication server, used for signing up and issuing tokens.

