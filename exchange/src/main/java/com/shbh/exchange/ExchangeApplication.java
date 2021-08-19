package com.shbh.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mazhuli
 */
@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
//@EnableHystrixDashboard
//@EnableCircuitBreaker
public class ExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
    }

}
