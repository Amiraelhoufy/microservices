package org.agcodes.fraud.service;

import org.agcodes.fraud.model.FraudCheckHistory;
import org.agcodes.fraud.repository.FraudCheckHistoryRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckService {

  private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

  // Use @AllArgsConstructor from Lombok instead
//  public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
//    this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
//  }

  public boolean isFraudulentCustomer(Integer customerId){
    // Store that the check took place
    fraudCheckHistoryRepository.save(
        FraudCheckHistory.builder()
            .customerId(customerId)
            .isFraudster(false)
            .createdAt(LocalDateTime.now())
            .build()
    );
    return false;
  }
}
