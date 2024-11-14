package com.agcodes.service;

import com.agcodes.model.Customer;
import com.agcodes.model.CustomerRegistrationRequest;
import com.agcodes.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository){

  public void registerCustomer(CustomerRegistrationRequest request) {
    Customer customer = Customer.builder()
        .firstName(request.firstName())
        .lastName(request.lastName())
        .email(request.email())
        .build();

    System.out.println(customer);

    // todo: check if email valid
    // todo: check if email not taken
    customerRepository.save(customer);
  }
}
