package com.luo.ad.task;

import com.luo.ad.service.HelloService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class HiJob extends QuartzJobBean {

    @Autowired
    HelloService helloService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        helloService.sayHi();
        System.out.println("Hi," + context.getJobDetail().getKey());
    }
}
