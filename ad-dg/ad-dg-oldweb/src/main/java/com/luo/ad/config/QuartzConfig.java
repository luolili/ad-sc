package com.luo.ad.config;

import com.luo.ad.task.HiJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class QuartzConfig {

    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(HiJob.class)
                .withIdentity("myJob1", "myJobGroup1")
                .usingJobData("job_param", "job_param1")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {

        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myTrigger1", "myTriggerGroup1")
                .usingJobData("trigger_param", "trigger_param1")

                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? 2019"))
                .build();
    }
}
