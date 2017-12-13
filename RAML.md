#%RAML 0.8
---
title: RAML SpringBoot Customer API
baseUri: http://localhost:8080
version: v1
mediaType: application/json

schemas:
  - customer: !include customer.json

/customers:
  description: "The Customers resource."
  get:
    description: "Returns a list of customers."
    responses:
      200:
        body:
          application/json:
            example: |
              [
                { "id": 1, "firstname": "Sara", "lastname": "Walawage", "address": "Sydney" },
                { "id": 2, "firstname": "Pramod", "lastname": "Batagoda", "address": "Sydney" }
              ]
  post:
    description: "Generate a new customer."
    body:
      application/json:
        schema: customer
        example: |
          { "firstname": "Inuka", "lastname": "Batagoda", "address": "Sydney" }
    responses:
      201:
        description: "Customer created"
      400:
        description: "Can't create Customer from provided entity"
  /{id}:
    uriParameters:
      id:
        type: integer
    get:
      description: "Return the customer with given id."
      responses:
        200:
          body:
            application/json:
              schema: customer
              example: |
                 { "id": 1, "firstname": "Sara", "lastname": "Walawage", "address": "Sydney" }
        404:
          description: "Customer with provided id not found"
    put:
      description: "Update the customer with given id."
      body:
        application/json:
          schema: customer
          example: |
            { "id": 1, "firstname": "Sara", "lastname": "Walawage", "address": "Melbourne" }
      responses:
        200:
          description: "Customer updated"
        404:
          description: "Customer with provided id not found"
    delete: