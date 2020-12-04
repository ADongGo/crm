package cn.offcn.controller;

import cn.offcn.entity.Employee;
import cn.offcn.service.LoginService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String loginPage(){

        return "/login/login";
    }

    @ResponseBody
    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public OAResult checkLogin(String username, String password, HttpSession session){

        OAResult result = loginService.checkLogin(username, password);
        if(result.getStatus()==200){

            session.setAttribute("activeUser",result.getData());
        }
        return result;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        if(session!=null){
            session.invalidate();
        }
        String contextPath=request.getContextPath();
        response.getWriter().println("<script>window.top.location='"+contextPath+"/login'</script>");
    }
}
