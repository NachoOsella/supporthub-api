package com.supporthub.api.notifications.repository;

import com.supporthub.api.notifications.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
