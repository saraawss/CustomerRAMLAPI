package customer.impl;

import customer.controller.CustomerController;
import customer.entity.CustomerTable;
import customer.repository.CustomerRepository;
import customer.controller.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *  @author Sara Walawage
 */
@Component
public class CustomerControllerImpl implements CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;


    @Override
    public ResponseEntity getCustomers() {
    	
    	List<Customer> customerJsonList = new ArrayList();
		List<CustomerTable> customerList = (List<CustomerTable>) customerRepository.findAll();
		
		for(CustomerTable customerTable : customerList) {
			Customer customer = new Customer();
			customer.setId(customerTable.getId());
			customer.setFirstname(customerTable.getFirstname());
			customer.setLastname(customerTable.getLastname());
			customer.setAddress(customerTable.getAddress());
			customerJsonList.add(customer);
		}
		 
		return ResponseEntity.ok(customerJsonList);
    }
    
    @Override
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
       
        CustomerTable customerTable = new CustomerTable();
        customerTable.setFirstname(customer.getFirstname());
        customerTable.setLastname(customer.getLastname());
        customerTable.setAddress(customer.getAddress());
        customerRepository.save(customerTable);
        
        return ResponseEntity.ok(customer);
        
    }

	@Override
	public ResponseEntity<Customer> getCustomerById(Long id) {
		CustomerTable customerTable = customerRepository.findOne(id);
		
		Customer customer = new Customer();
		
		if(customerTable != null) {
			customer.setId(customerTable.getId());
			customer.setFirstname(customerTable.getFirstname());
			customer.setLastname(customerTable.getLastname());
			customer.setAddress(customerTable.getAddress());
		}
		
		return ResponseEntity.<Customer>ok().body(customer);
	}

	@Override
	public ResponseEntity<?> deleteCustomerById(Long id) {
		CustomerTable customerTable = new CustomerTable();
		customerTable.setId(id);
		customerRepository.delete(customerTable);
		return ResponseEntity.ok(customerTable);
	}


	@Override
	public ResponseEntity<?> updateCustomerById(Long id, Customer customer) {
		
		CustomerTable customerTable = new CustomerTable();
		customerTable.setId(id);
        customerTable.setFirstname(customer.getFirstname());
        customerTable.setLastname(customer.getLastname());
        customerTable.setAddress(customer.getAddress());
        customerRepository.save(customerTable);
        
        return ResponseEntity.ok(customer);
	}



   


}
