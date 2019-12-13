package com.luo.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 1.git init
 * Cannot clone or checkout repository: F:\githubpro\ad-sc\src\main\resources\configs
 * git add .
 * git commit -m "cc"
 * 配置的mapping
 * /application/profile
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class, args);
    }
}
