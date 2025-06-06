package org.agcodes.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
    scanBasePackages = {
        "org.agcodes.customer",
        "org.agcodes.clients",
        "org.agcodes.amqp"}
)
@EnableEurekaClient
@EnableFeignClients(
    basePackages = "org.agcodes.clients"
)
public class CustomerApplication {
  public static void main(String[] args) {
    SpringApplication.run(CustomerApplication.class,args);
  }

}
