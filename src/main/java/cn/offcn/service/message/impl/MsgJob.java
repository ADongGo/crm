package cn.offcn.service.message.impl;

import cn.offcn.entity.Msg;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MsgJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        /*
         * 1:连接数据库
         * 2:需要在获取表单数据
         * */

        try {
            System.out.println("====================");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa","root","123456");
            PreparedStatement ps = con.prepareStatement("insert into msg(sendp,recvp,mark,msgcontent,msgtime)  values(?,?,?,?,?)");
            Msg msg = (Msg)jobExecutionContext.getJobDetail().getJobDataMap().get("msg");
            Scheduler scheduler = (Scheduler)jobExecutionContext.getJobDetail().getJobDataMap().get("scheduler");
            msg.setMark(0);
            System.out.println("============"+msg.getMsgcontent());
            ps.setInt(1,msg.getSendp());
            ps.setInt(2,msg.getRecvp());
            ps.setInt(3,msg.getMark());
            ps.setString(4,msg.getMsgcontent());
            ps.setObject(5,msg.getMsgtime());
            int i = ps.executeUpdate();
            System.out.println("消息已存入表中");
            ps.close();
            con.close();
            scheduler.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
