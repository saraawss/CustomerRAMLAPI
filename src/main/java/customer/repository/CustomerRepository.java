package customer.repository;

import org.springframework.data.repository.CrudRepository;

import customer.entity.CustomerTable;

public interface CustomerRepository extends CrudRepository<CustomerTable,Long> {

}
