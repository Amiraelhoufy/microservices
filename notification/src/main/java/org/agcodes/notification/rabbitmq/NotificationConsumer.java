package org.agcodes.notification.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.agcodes.clients.notification.NotificationRequest;
import org.agcodes.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class NotificationConsumer {

  private final NotificationService notificationService;
  @RabbitListener(queues = "${rabbitmq.queue.notification}")
  public void consumer(NotificationRequest notificationRequest){

    log.info("Consumed {} from queue",notificationRequest);
    // Storing to db
    notificationService.send(notificationRequest);
  }
}
