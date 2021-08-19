package com.shbh.admin.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author MaZhuli
 * @date 2020.12.15
 * @desc Eureka服务2
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication2.class, args);
    }

}
