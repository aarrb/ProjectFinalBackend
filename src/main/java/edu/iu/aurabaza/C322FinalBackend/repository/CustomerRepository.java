package edu.iu.aurabaza.C322FinalBackend.repository;

import edu.iu.aurabaza.C322FinalBackend.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customer, String> {
    Customer findByUsername(String username);

}