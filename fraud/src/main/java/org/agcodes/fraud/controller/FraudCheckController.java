package org.agcodes.fraud.controller;

import org.agcodes.clients.fraud.FraudCheckResponse;
import org.agcodes.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckController {

  private final FraudCheckService fraudCheckService;

  @GetMapping(path="{customerId}")
  public FraudCheckResponse isFraudster(
      @PathVariable("customerId") Integer customerId){

    boolean isFraudulentCustomer =
        fraudCheckService.isFraudulentCustomer(customerId);
    log.info("fraud check request for customer {}",customerId);

    // return as a response object not boolean
    return new FraudCheckResponse(isFraudulentCustomer);
  }
}
