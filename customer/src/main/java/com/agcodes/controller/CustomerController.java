package com.agcodes.controller;

import com.agcodes.service.CustomerService;
import com.agcodes.model.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

  @PostMapping
  public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegisterationRequest){

    log.info("new customer registration {}", customerRegisterationRequest);
    customerService.registerCustomer(customerRegisterationRequest);
  }
}
