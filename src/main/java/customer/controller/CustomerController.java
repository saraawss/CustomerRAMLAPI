
package customer.controller;

import org.springframework.http.ResponseEntity;


/**
 * The Customers resource.
 * (Generated with springmvc-raml-parser v.0.10.11)
 * 
 */
public interface CustomerController {


    /**
     * Returns a list of customers.
     * 
     */
    public ResponseEntity<?> getCustomers();

    /**
     * Generate a new customer.
     * 
     */
    public ResponseEntity<?> createCustomer(customer.controller.Customer customer);

    /**
     * Return the customer with given id.
     * 
     */
    public ResponseEntity<customer.controller.Customer> getCustomerById(Long id);

    /**
     * Update the customer with given id.
     * 
     */
    public ResponseEntity<?> updateCustomerById(Long id, customer.controller.Customer customer);

    /**
     * No description
     * 
     */
    public ResponseEntity<?> deleteCustomerById(Long id);

}
