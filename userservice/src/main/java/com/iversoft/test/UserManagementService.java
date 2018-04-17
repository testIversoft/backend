package com.iversoft.test;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringCloudApplication
@EnableJpaAuditing
public class UserManagementService {
    public static void main(String[] args) {
        SpringApplication.run(UserManagementService.class, args);
    }
}
