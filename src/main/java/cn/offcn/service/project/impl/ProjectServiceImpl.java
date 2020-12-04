package cn.offcn.service.project.impl;

import cn.offcn.entity.*;
import cn.offcn.mapper.AnalysisMapper;
import cn.offcn.mapper.CustomerMapper;
import cn.offcn.mapper.EmployeeMapper;
import cn.offcn.mapper.ProjectMapper;
import cn.offcn.service.project.ProjectService;
import cn.offcn.utils.OAResult;
import cn.offcn.utils.PageView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private AnalysisMapper analysisMapper;

    @Override
    public OAResult addProject(Project project) {

        int insert = projectMapper.insert(project);

        if (insert == 1) {
            return OAResult.ok(200, "添加成功");
        } else {
            return OAResult.ok(400, "添加失败");
        }
    }

    @Override
    public List<Project> getAllProject() {

        List<Project> projects = projectMapper.selectByExample(new ProjectExample());
        for (Project project : projects) {
            //查customer
            Customer customer = customerMapper.selectByPrimaryKey(project.getCustomerId());
            project.setCustomer(customer);
            //查employee
            Employee employee = employeeMapper.selectByPrimaryKey(project.getEmpFk());
            project.setEmployee(employee);
        }

        return projects;
    }

    @Override
    public List<Project> getAllProjectByNoNeed() {

        List<Analysis> analyses = analysisMapper.selectByExample(new AnalysisExample());
        List<Integer> analysesIns = new ArrayList<>();
        for (Analysis analysis : analyses) {
            analysesIns.add(analysis.getId());
        }
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andPidNotIn(analysesIns);
        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public List<Project> getAllProjectByNeed() {
        List<Analysis> analyses = analysisMapper.selectByExample(new AnalysisExample());
        List<Integer> analysesIns = new ArrayList<>();
        for (Analysis analysis : analyses) {
            analysesIns.add(analysis.getId());
        }
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andPidIn(analysesIns);
        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public List<Project> getAllProjectByModule() {

        return projectMapper.getProjectByModule();
    }

    @Override
    public List<Project> getProjectByFunctionAndEid(int eid) {

        return projectMapper.getProjectByFunctionAndEid(eid);
    }

    public Project getProjectById(int pid) {

        Project project = projectMapper.selectByPrimaryKey(pid);
        project.setEmployee(employeeMapper.selectByPrimaryKey(project.getEmpFk()));
        project.setCustomer(customerMapper.selectByPrimaryKey(project.getCustomerId()));
        return project;
    }

    @Override
    public PageView<Project> showProject(int currentPage, int searchC, String keyword, int orderby, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        ProjectExample projectExample = new ProjectExample();
        if (searchC != 0) {
            if (searchC == 1) {
                if (StringUtils.isNotBlank(keyword)) {
                    ProjectExample.Criteria criteria = projectExample.createCriteria();
                    criteria.andPnameLike("%" + keyword + "%");
                }
            }
            if (searchC == 2) {
                if (StringUtils.isNotBlank(keyword)) {
                    ProjectExample.Criteria criteria = projectExample.createCriteria();
                    EmployeeExample employeeExample=new EmployeeExample();
                    EmployeeExample.Criteria criteria1 = employeeExample.createCriteria();
                    criteria1.andEnameLike("%" + keyword + "%");
                    List<Employee> employees = employeeMapper.selectByExample(employeeExample);
                    List<Integer> eids=new ArrayList();
                    for(Employee employee:employees){
                        eids.add(employee.getEid());
                    }
                    criteria.andEmpFkIn(eids);
                }
            }
        }
        if(orderby!=0){
            if(orderby==1){
                projectExample.setOrderByClause("buildtime DESC");
            }
            if(orderby==2){
                projectExample.setOrderByClause("endtime DESC");
            }
        }
        List<Project> projects = projectMapper.selectByExample(projectExample);
        for (Project project : projects) {
            //查customer
            Customer customer = customerMapper.selectByPrimaryKey(project.getCustomerId());
            project.setCustomer(customer);
            //查employee
            Employee employee = employeeMapper.selectByPrimaryKey(project.getEmpFk());
            project.setEmployee(employee);
        }
        PageInfo<Project> pageInfo=new PageInfo<>(projects);
        PageView<Project> pageView=new PageView<>(currentPage,pageSize);
        pageView.setTotalrecords(pageInfo.getTotal());
        pageView.setRecords(pageInfo.getList());
        return pageView;
    }
}