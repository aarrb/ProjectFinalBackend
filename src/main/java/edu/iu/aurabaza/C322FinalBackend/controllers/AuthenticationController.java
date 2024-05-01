package edu.iu.aurabaza.C322FinalBackend.controllers;

import edu.iu.aurabaza.C322FinalBackend.model.Customer;
import edu.iu.aurabaza.C322FinalBackend.repository.CustomerRepository;
import edu.iu.aurabaza.C322FinalBackend.repository.FlowersRepository;
import edu.iu.aurabaza.C322FinalBackend.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    CustomerRepository customerRepository;

    FlowersRepository flowersRepository;
    public AuthenticationController(AuthenticationManager
                                            authenticationManager,
                                    TokenService tokenService,
                                    CustomerRepository
                                            customerRepository, FlowersRepository flowersRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.customerRepository = customerRepository;
        this.flowersRepository = flowersRepository;
    }
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String passwordEncoder = bc.encode(customer.getPassword());
            customer.setPassword(passwordEncoder);
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                customer.getUsername()
                                , customer.getPassword()));

        return tokenService.generateToken(authentication);
    }
}
