package com.luo.ad;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * http://localhost:8000/
 */
@EnableFeignClients
//@EnableFeignClients(clients = {UserService.class})
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringCloudApplication//spring cloud bootstrap 上下文先于sb创建，事件创建上下文
public class SearchApplication {
    public static void main(String[] args) {

        //SpringApplication.run(SearchApplication.class, args);
        //java: user.dir:F:\githubpro\ad-sc
        System.out.println("user.dir:" + System.getProperty("user.dir"));
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {

        return new RestTemplate();
    }


}
