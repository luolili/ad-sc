package com.luo.ad.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 传统的解决方法
 */
@Slf4j
@RestController
public class DemoRestCtr {

    private static final Random random = new Random();

    /**
     * 方法 执行超过100秒，抛出异常
     *
     * @return
     */
    @GetMapping("")
    public String index() throws Exception {
        long executeTime = random.nextInt(200);
        if (executeTime > 100) {
            throw new TimeoutException("exec timeout");
        }
        return "ok";
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
    }, fallbackMethod = "fallbackForIndex2")
    @GetMapping("/hystrix")
    public String index2() throws Exception {
        long executeTime = random.nextInt(200);
        log.info("time:{}", executeTime);
        //Thread.sleep(executeTime);
        TimeUnit.MILLISECONDS.sleep(executeTime);
        return "ok";
    }

    //反馈信息
    public String fallbackForIndex2() {

        return "timeout--";
    }
}
