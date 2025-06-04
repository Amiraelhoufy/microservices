package org.agcodes.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    path = "api/v1/notification",
    value = "notification"
)
public interface NotificationClient {
  @PostMapping
  public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
