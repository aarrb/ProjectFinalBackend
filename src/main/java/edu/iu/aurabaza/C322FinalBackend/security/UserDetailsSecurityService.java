package edu.iu.aurabaza.C322FinalBackend.security;

import edu.iu.aurabaza.C322FinalBackend.repository.CustomerRepository;
import edu.iu.aurabaza.C322FinalBackend.model.Customer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsSecurityService implements
        UserDetailsService {
    CustomerRepository customerRepository;

    public UserDetailsSecurityService(CustomerRepository
                                              customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        try {
            Customer customer =
                    customerRepository.findByUsername(username);
            if(customer == null) {
                throw new UsernameNotFoundException("");
            }
            return User
                    .withUsername(username)
                    .password(customer.getPassword())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}