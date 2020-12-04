package cn.offcn.service.message.impl;

import cn.offcn.entity.Email;
import cn.offcn.service.message.EmailService;
import cn.offcn.utils.OAResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public OAResult saveEmail(Email email, String reemp, MultipartFile file) throws Exception {

        //文件上传获取文件路径
        String path="D:\\AAA_date\\workspace\\attachment\\upload";
        if(file!=null && file.getSize()>0){
            path += file.getOriginalFilename();
            File nfile =  new File(path);
            file.transferTo(nfile);
        }else{
            path="";
        }

        //开发线程去发送邮件

        return null;
    }

    class SendEmailTask extends Thread{
        Email email;
        String reemp;
        String path;
        public SendEmailTask(Email email,String reemp,String path){
            this.email=email;
            this.reemp=reemp;
            this.path=path;
        }
        public void run(){
            try{
                sendMail(email,reemp, path);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public  static void sendMail(Email email, String reemp,String path)throws Exception{

        System.out.println(email.getEmailcontent()+":"+email.getTitle());
        //        // 发件人的邮箱和密码
        String myEmailAccount = "cctvtype@163.com";
        String myEmailPassword = "cctvtype001";// 邮箱密码
        // 收件人邮箱
        String receiveMailAccount = reemp;
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();  // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");// 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", "smtp.163.com");// 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "false");// 需要请求认证
        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                // 密码验证
                return new PasswordAuthentication("cctvtype@163.com", "RONROHGJBUAOPXOP");// 邮箱的授权码
            }
        };

        //当前程序和网易邮件服务器之间的交互会话
        Session session = Session.getInstance(props,auth);
        //开启debug模式  查看邮件的发送状态
        session.setDebug(true);

        //创建一个邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(myEmailAccount));
        //给自己的当前抄送一份
        message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(myEmailAccount));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMailAccount));
        //邮件的标题
        message.setSubject(email.getTitle(), "UTF-8");

        // 创建一个封装多个消息容器 map
        Multipart multipart = new MimeMultipart();

        // 创建消息部分
        BodyPart messageBodyPart = new MimeBodyPart();
        // 包装文本内容
        messageBodyPart.setText(email.getEmailcontent());

        // 设置文本消息部分
        multipart.addBodyPart(messageBodyPart);

        if(StringUtils.isNotBlank(path)){
            // 附件部分
            messageBodyPart = new MimeBodyPart();
            // 设置要发送附件的文件路径
            DataSource source = new FileDataSource(path);
            messageBodyPart.setDataHandler(new DataHandler(source));
            // messageBodyPart.setFileName(filename);
            // 处理附件名称中文（附带文件路径）乱码问题
            messageBodyPart.setFileName(MimeUtility.encodeText(path));
            //邮件内容添加到容器中
            multipart.addBodyPart(messageBodyPart);
        }

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(multipart);
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();

        //创建发送邮件对象
        Transport transport = session.getTransport();
        //设定当前邮箱的名称和密码
        transport.connect(myEmailAccount, myEmailPassword);
        //发送邮件对象和抄送人
        transport.sendMessage(message, message.getAllRecipients());
        //关闭当前程序和邮件服务器之间的连接
        transport.close();
    }
}
