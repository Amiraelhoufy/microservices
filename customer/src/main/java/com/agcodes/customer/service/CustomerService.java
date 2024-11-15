package com.agcodes.customer.service;

import com.agcodes.customer.configuration.CustomerConfiguration;
import com.agcodes.customer.model.FraudCheckResponse;
import com.agcodes.customer.repository.CustomerRepository;
import com.agcodes.customer.model.Customer;
import com.agcodes.customer.model.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate){

  public void registerCustomer(CustomerRegistrationRequest request) {
    Customer customer = Customer.builder()
        .firstName(request.firstName())
        .lastName(request.lastName())
        .email(request.email())
        .build();

    System.out.println(customer);

    // todo: check if email valid
    // todo: check if email not taken
    // todo: check if fraudster

    /*
        saveAndFlush: to retrieve the id of the saved customer
        save: the id for customer object will be null (Not retrieved)
    */
    customerRepository.saveAndFlush(customer);
    FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//        "http://localhost:8081/api/v1/fraud-check/{customerId}"
        "http://FRAUD/api/v1/fraud-check/{customerId}"
        , FraudCheckResponse.class
        , customer.getId());

    if(fraudCheckResponse.isFraudster()){
      throw new IllegalStateException("Fraudster!");
    }

    // todo: send notification

  }
}
