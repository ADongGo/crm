package cn.offcn.service;

import cn.offcn.entity.Employee;
import cn.offcn.entity.EmployeeExample;
import cn.offcn.mapper.EmployeeMapper;
import cn.offcn.utils.OAResult;
import com.sun.mail.smtp.DigestMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public OAResult checkLogin(String username,String password) {

        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        password= DigestUtils.md5DigestAsHex(password.getBytes());
        criteria.andPasswordEqualTo(password);

        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if(employees.size()==1){
            System.out.println(employees.size());
            return OAResult.ok(200,"登录成功",employees.get(0));
        }

        return OAResult.ok(400,"登录失败");
    }
}
