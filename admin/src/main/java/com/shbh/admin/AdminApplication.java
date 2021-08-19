package com.shbh.admin;

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
//lcn分布式事务
@EnableDistributedTransaction
@MapperScan("com.shbh.admin.mapper")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
