package cn.offcn.service.message;

import cn.offcn.entity.Msg;
import cn.offcn.utils.OAResult;

import javax.servlet.http.HttpSession;

public interface MessageService {

    /**
     * 定时发送并保存
     * @param msg
     * @return
     */
    public OAResult sendMsg (Msg msg, HttpSession session)throws Exception;
}
