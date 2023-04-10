package com.rurigokou.plugin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gokoururi
 */
@EnableFeignClients
@SpringBootApplication
public class LazuriteGrovePluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazuriteGrovePluginApplication.class, args);
    }
}
