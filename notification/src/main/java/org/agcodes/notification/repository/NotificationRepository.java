package org.agcodes.notification.repository;

import org.agcodes.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NotificationRepository extends JpaRepository<Notification,Integer> {

}
