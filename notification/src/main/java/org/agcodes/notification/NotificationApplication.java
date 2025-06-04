package org.agcodes.notification;

import lombok.extern.slf4j.Slf4j;
import org.agcodes.amqp.producer.RabbitMQMessageProducer;
import org.agcodes.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication(
    scanBasePackages = {"org.agcodes.notification","org.agcodes.amqp","org.agcodes.clients"}
)
public class NotificationApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationApplication.class,args);
  }

  // To inject the producer
  /*
  @Bean
  CommandLineRunner commandLineRunner(
      RabbitMQMessageProducer rabbitMQMessageProducer,
      NotificationConfig notificationConfig){

    return args -> {
      rabbitMQMessageProducer.publish(
//          "foo"
          new Person("John",28)
          ,notificationConfig.getInternalExchange()
          ,notificationConfig.getInternalNotificationRoutingKeys());
    };
  }
  record Person(String name, int age){}
  */
}
