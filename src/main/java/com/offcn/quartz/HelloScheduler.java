package com.offcn.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {

    public static void main(String[] args) throws Exception {
        JobDetail helloJob = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob").build();
        CronTrigger trigger1= TriggerBuilder.newTrigger().withIdentity("trigger1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 09 20 * * ? "))
                .build();
        StdSchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(helloJob,trigger1);
    }
}
