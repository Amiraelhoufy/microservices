package com.agcodes.customer.service;

import com.agcodes.clients.fraud.FraudCheckResponse;
import com.agcodes.clients.fraud.FraudClient;
import com.agcodes.clients.notification.NotificationClient;
import com.agcodes.clients.notification.NotificationRequest;
import com.agcodes.customer.repository.CustomerRepository;
import com.agcodes.customer.model.Customer;
import com.agcodes.customer.model.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate,
                              FraudClient fraudClient,
                              NotificationClient notificationClient){

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

    // ------------- Before Using OpenFeign -------------
    /*
    FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//        "http://localhost:8081/api/v1/fraud-check/{customerId}"
        "http://FRAUD/api/v1/fraud-check/{customerId}"
        , FraudCheckResponse.class
        , customer.getId());

    */
    FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

    if(fraudCheckResponse.isFraudster()){
      throw new IllegalStateException("Fraudster!");
    }

    // Send notification
    // todo: make it async i.e add it to queue
      notificationClient.sendNotification(
          new NotificationRequest(
            customer.getId(),
            customer.getEmail(),
            String.format("Hi %s, Welcome to Homepage.",customer.getFirstName()))
      );

  }
}
