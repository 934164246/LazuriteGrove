package com.rurigokou.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gokoururi
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class LazuriteGroveBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazuriteGroveBackApplication.class, args);
    }
}