package com.shbh.article;

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
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }

}
