package cn.offcn.service;

import cn.offcn.utils.OAResult;

public interface LoginService {


    /**
     * 登录验证
     * @return
     */
    public OAResult checkLogin(String username,String password);
}
