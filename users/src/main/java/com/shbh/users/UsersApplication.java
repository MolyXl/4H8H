package com.shbh.users;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Mazhuli
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
//@EnableHystrixDashboard
//@EnableCircuitBreaker
@EnableDistributedTransaction
@MapperScan("com.shbh.users.mapper")
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

}
