package org.agcodes.amqp.config;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig {

  private final ConnectionFactory connectionFactory;
  @Bean
  public AmqpTemplate amqpTemplate() {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
   rabbitTemplate.setMessageConverter(jacksonConverter());
    return rabbitTemplate;
  }

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
    // Consume/Receive MSGs (Listener)
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(jacksonConverter());
    return factory;
  }

  @Bean
  public MessageConverter jacksonConverter(){
    // Configuring a bean that serialize/convert Java objects to JSON as RabbitMQ (and most message brokers) send/receive messages as "raw bytes"
    // Useful in case of passing a JSON Object Mapper
    // Example
    /*
     Jackson2ObjectMapperBuilder jsonBuilder = Jackson2ObjectMapperBuilder.json()
            .modules(new JavaTimeModule()) // Support for Java 8 date/time
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // Format dates as ISO-8601
            .serializationInclusion(JsonInclude.Include.NON_NULL) // Ignore null fields
            .indentOutput(true) // Pretty print JSON
            .build();
    */
    Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
    return messageConverter;
  }
}
