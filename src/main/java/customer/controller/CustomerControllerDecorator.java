
package customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * The Customers resource.
 * (Generated with springmvc-raml-parser v.0.10.11)
 * 
 */
@RestController
@RequestMapping(value = "/api/customers", produces = "application/json")
@Validated
public class CustomerControllerDecorator
    implements CustomerController
{

    @Autowired
    private CustomerController customerControllerDelegate;

    /**
     * Returns a list of customers.
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomers() {
        return this.customerControllerDelegate.getCustomers();
    }

    /**
     * Generate a new customer.
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(
        @javax.validation.Valid
        @org.springframework.web.bind.annotation.RequestBody
        customer.controller.Customer customer) {
        return this.customerControllerDelegate.createCustomer(customer);
    }

    /**
     * Return the customer with given id.
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<customer.controller.Customer> getCustomerById(
        @PathVariable(required = false)
        Long id) {
        return this.customerControllerDelegate.getCustomerById(id);
    }

    /**
     * Update the customer with given id.
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomerById(
        @PathVariable(required = false)
        Long id,
        @javax.validation.Valid
        @org.springframework.web.bind.annotation.RequestBody
        customer.controller.Customer customer) {
        return this.customerControllerDelegate.updateCustomerById(id, customer);
    }

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomerById(
        @PathVariable(required = false)
        Long id) {
        return this.customerControllerDelegate.deleteCustomerById(id);
    }

}
