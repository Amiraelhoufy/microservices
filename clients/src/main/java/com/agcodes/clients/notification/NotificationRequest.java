package com.agcodes.clients.notification;

public record NotificationRequest(
    Integer toCustomerId,
    String toCustomerName,
    String message
) {
}