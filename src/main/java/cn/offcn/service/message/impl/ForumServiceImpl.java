package cn.offcn.service.message.impl;

import cn.offcn.entity.*;
import cn.offcn.mapper.EmployeeMapper;
import cn.offcn.mapper.EvaluateMapper;
import cn.offcn.mapper.ForumpostMapper;
import cn.offcn.service.message.ForumService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumpostMapper forumpostMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public void addForumpost(Forumpost forumpost) {

        forumpost.setCreatetime(new Date());
        forumpost.setStats(1);
        forumpostMapper.insert(forumpost);
    }

    public List<Forumpost> showForumByEid(int eid){

        ForumpostExample forumpostExample=new ForumpostExample();
        forumpostExample.setOrderByClause("createtime DESC");
        ForumpostExample.Criteria criteria = forumpostExample.createCriteria();
        criteria.andEmpfk3EqualTo(eid);

        List<Forumpost> forumposts = forumpostMapper.selectByExample(forumpostExample);
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        for(Forumpost forumpost:forumposts){
            forumpost.setEmployee(employee);
        }
        return forumposts;
    }

    @Override
    public Forumpost getForumpostByFroumId(int forumid) {

        ForumpostExample forumpostExample=new ForumpostExample();
        ForumpostExample.Criteria criteriaf = forumpostExample.createCriteria();
        criteriaf.andForumidEqualTo(forumid);
        Forumpost forumpost=forumpostMapper.selectByExampleWithBLOBs(forumpostExample).get(0);
        //设置发帖人
        Employee employee = employeeMapper.selectByPrimaryKey(forumpost.getEmpfk3());
        forumpost.setEmployee(employee);
        //找到帖子所有的评论
        EvaluateExample evaluateExample=new EvaluateExample();
        EvaluateExample.Criteria criteria = evaluateExample.createCriteria();
        criteria.andForumfkEqualTo(forumid);
        List<Evaluate> evaluateList = evaluateMapper.selectByExampleWithBLOBs(evaluateExample);
        for(Evaluate evaluate:evaluateList){
            //设置评论人
            evaluate.setEmployee(employeeMapper.selectByPrimaryKey(evaluate.getEmpfk()));
            //设置对谁评论
            if(evaluate.getEvaid()==null){
                evaluate.setEmployee2(employee);
            }else{
                evaluate.setEmployee2(getEmployeeByEvaidFk(evaluate.getEvaid()));
            }
        }
        forumpost.setEvaluateList(evaluateList);
        return forumpost;
    }

    public Employee getEmployeeByEvaidFk(int evaid){

        Evaluate evaluate = evaluateMapper.selectByPrimaryKey(evaid);
        return employeeMapper.selectByPrimaryKey(evaluate.getEmpfk());
    }

    public List<Forumpost> forumpostTop9(int flag){

        ForumpostExample forumpostExample=new ForumpostExample();
        forumpostExample.setOrderByClause("createtime DESC limit 0,"+flag);
        List<Forumpost> forumposts = forumpostMapper.selectByExample(forumpostExample);
        for(Forumpost forumpost:forumposts){
            Employee employee = employeeMapper.selectByPrimaryKey(forumpost.getEmpfk3());
            forumpost.setEmployee(employee);
        }
        return forumposts;
    }

    public void addEvaluate(Evaluate evaluate){

        evaluate.setEvatime(new Date());
        evaluate.setUpdatetime(new Date());
        evaluateMapper.insert(evaluate);
    }

    public List<Forumpost> showYi(int eid){

        ForumpostExample forumpostExample=new ForumpostExample();
        forumpostExample.setOrderByClause("createtime DESC");
        ForumpostExample.Criteria criteria = forumpostExample.createCriteria();
        criteria.andEmpfk3EqualTo(eid);

        List<Forumpost> forumposts = forumpostMapper.selectByExample(forumpostExample);
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        for(Forumpost forumpost:forumposts){
            forumpost.setEmployee(employee);
        }
        return forumposts;
    }
}
