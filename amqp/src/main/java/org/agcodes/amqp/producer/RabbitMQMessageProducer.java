package org.agcodes.amqp.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class RabbitMQMessageProducer {

  private final AmqpTemplate amqpTemplate;
  public void publish(Object payload, String exchange, String routingKey) {
    log.info("publishing payload='{}' to exchange='{}' with routing key='{}'", payload, exchange, routingKey);
    amqpTemplate.convertAndSend(exchange, routingKey, payload);
    log.info("Published payload='{}' to exchange='{}' with routing key='{}'", payload, exchange, routingKey);

  }
}
