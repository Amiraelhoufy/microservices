package com.agcodes.fraud.controller;

import com.agcodes.fraud.model.FraudCheckResponse;
import com.agcodes.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudCheckController {

  private final FraudCheckService fraudCheckService;
  
  @GetMapping(path="{customerId}")
  public FraudCheckResponse isFraudster(
      @PathVariable("customerId") Integer customerId){

    boolean isFraudulentCustomer =
        fraudCheckService.isFraudulentCustomer(customerId);
    log.info("fraud check request for customer {}",customerId);

    return new FraudCheckResponse(isFraudulentCustomer);
  }
}
