package cn.offcn.service.message;

import cn.offcn.entity.Email;
import cn.offcn.utils.OAResult;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

    /**
     * 保存邮件并发送
     * @param email
     * @param reemp
     * @param file
     * @return
     * @throws Exception
     */
    public OAResult saveEmail(Email email, String reemp, MultipartFile file)throws  Exception;
}
