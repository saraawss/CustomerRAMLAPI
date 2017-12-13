# Customer API
## Overview
This system is implemented by RAML, Java, SpringBoot.

Generated CustomerController.java and CustomerControllerDecorator.java using api.raml and extended rest call methods in CustomerControllerImpl.java.Used h2 database to store data and used flyway to execute the sql scripts.

To run the application

java -jar de.adorsys.jar

case 1 : Able to create a class extending TimerTask(available in java.util package). TimerTask is a abstract class.Api call is written in public void run() method that need to execute periodically.

case 2 : Able to design a mobile application using ionic and Angular calling by customer.impl.CustomerControllerImpl.getCustomers and customer.impl.CustomerControllerImpl.updateCustomerById 

case 3 : Able to extend the application to use Orders and Products.In api.raml is extended by adding orders and products and genarating that raml to Order.java and Product.java and controller java classes.Then override rest methods in customer.impl.CustomerControllerImpl.

I generated Authorized code using by Spring security and JWT

### For API Document, please refer API.md
### For RAML spec, please refer RAML.md