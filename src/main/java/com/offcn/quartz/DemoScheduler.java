package com.offcn.quartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class DemoScheduler {

    public static void main(String[] args) throws Exception {

        //创建JobDetail对象
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob").build();
        //创建一个触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3)
                        .repeatForever())
                .build();
        //创建schedule工厂实例
        StdSchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
