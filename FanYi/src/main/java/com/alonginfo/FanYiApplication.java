package com.alonginfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/11/30 16:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FanYiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FanYiApplication.class, args);
    }

}
