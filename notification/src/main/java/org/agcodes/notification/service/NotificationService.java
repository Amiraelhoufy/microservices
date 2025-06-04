package org.agcodes.notification.service;

import org.agcodes.clients.notification.NotificationRequest;
import org.agcodes.notification.model.Notification;
import org.agcodes.notification.repository.NotificationRepository;
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
