package com.iversoft.test;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class RouterService {
    public static void main(String[] args) {
        SpringApplication.run(RouterService.class, args);
    }
}
