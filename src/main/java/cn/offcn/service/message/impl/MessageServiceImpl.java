package cn.offcn.service.message.impl;

import cn.offcn.entity.Employee;
import cn.offcn.entity.Msg;
import cn.offcn.service.message.MessageService;
import cn.offcn.utils.OAResult;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public OAResult sendMsg(Msg msg, HttpSession session)throws Exception{
        Employee emplyee=(Employee)session.getAttribute("activeUser");
        msg.setSendp(emplyee.getEid());
        //1.创建调用Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2.从工厂中获取调度器实例
        Scheduler scheduler = sf.getScheduler();

        //3.创建JobDetail
        JobDetail jb = JobBuilder.newJob(MsgJob.class)
                .withIdentity("ramJob", "ramGroup") //job 的name和group(名称自己定义)
                .build();



        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("ramTrigger", "ramGroup")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(msg.getMsgtime())//设定任务的启动时间
                .build();
        //给我们的job方法传递参数
        jb.getJobDataMap().put("msg",msg);
        jb.getJobDataMap().put("scheduler",scheduler);
        //使用调度器将我们的job和trigger绑定到一起
        scheduler.scheduleJob(jb,trigger);

        if(!scheduler.isShutdown()){
            scheduler.start();
            return OAResult.ok(200,"定时消息已启动");
        }
        return OAResult.ok(400,"定时消息启动失败");
    }
}

