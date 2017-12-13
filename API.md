# Title    
# Customer API

Customer API is allowed to list the all customer's details, submit a customer, modify the customer and delete the customer.

## URI
http://localhost:8080

## Authentication

## POST

### URI  
/login

### BODY
{
    "username":"admin",
    "password":"password"
}

Generating the Authorization code in Headers

## Method

GET | POST | DELETE | PUT

## URI Params    

Required:
id=[integer]
example: id=12

## Data Params
    
Example:

## GET
To get the customer list

### Headers
Authorization : Generated Authorization code

### URI    
/api/customers
/api/customers/:id

## POST
To submit the customer

### Headers
Authorization : Generated Authorization code

### URI   
/api/customers
 
### BODY
{
    "firstname" : "[string]",
    "lastname" : "[string]",
    "address" : "[string]"
}

## PUT
To update the customer

### Headers
Authorization : Generated Authorization code

### URI    
/api/customers/:id

### BODY
{
    "id" : [integer]
    "firstname" : "[string]",
    "lastname" : "[string]",
    "address" : "[string]"
}

## DELETE
To delete the customer

### Headers
Authorization : Generated Authorization code

### URI
/api/customers/:id

## Success Response    
Code: 200
Content: { {
    "id" : [integer],
    "firstname" : "[string]",
    "lastname" : "[string]",
    "address" : "[string]"
} }

## Error Response    
Code: 400 - Bad Request - the request could not be understood or was missing required parameters.
Code: 401 - authentication failed or user doesn't have permissions for requested operation.
Code: 403 - Forbidden - access denied
Code: 404 - resource was not found.