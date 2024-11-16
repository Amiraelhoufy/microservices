package com.agcodes.notification.repository;

import com.agcodes.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NotificationRepository extends JpaRepository<Notification,Integer> {

}
