package com.agcodes.notification.service;

import com.agcodes.clients.notification.NotificationRequest;
import com.agcodes.notification.model.Notification;
import com.agcodes.notification.repository.NotificationRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

  private final NotificationRepository notificationRepository;

  public void send(NotificationRequest notificationRequest){
    notificationRepository.save(
        Notification.builder()
            .toCustomerId(notificationRequest.toCustomerId())
            .toCustomerEmail(notificationRequest.toCustomerName())
            .sender("Server")
            .message(notificationRequest.message())
            .sentAt(LocalDateTime.now())
            .build());
  }
  }
