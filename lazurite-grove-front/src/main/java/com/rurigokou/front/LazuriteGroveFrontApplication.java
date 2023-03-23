package com.rurigokou.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gokoururi
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LazuriteGroveFrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(LazuriteGroveFrontApplication.class, args);
    }
}