package cn.offcn.service.office.impl;

import cn.offcn.entity.Task;
import cn.offcn.entity.TaskExample;
import cn.offcn.mapper.TaskMapper;
import cn.offcn.service.office.TaskService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public OAResult saveTask(Task task) {
        task.setStatus(1);
        int rows=taskMapper.insert(task);
        if(rows==1){
            return OAResult.ok(200,"任务分配成功");
        }
        return OAResult.ok(400,"任务分配失败");
    }

    @Override
    public List<Task> getTaskByEmployee(int eid) {
        return taskMapper.getTaskByEmployee(eid);
    }

    public List<Task> getMyTaskEmployee(int eid){

        TaskExample taskExample=new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andEmpFk2EqualTo(eid);
        return taskMapper.selectByExample(taskExample);
    }

    @Override
    public OAResult updateTaskStatus(int id, int status) {

        Task task = taskMapper.selectByPrimaryKey(id);
        int oldstatus = task.getStatus();
        if(oldstatus==3 && (status==1||status==2)){
            return OAResult.ok(400,"任务已完成,无法更改");
        }
        if(oldstatus==2 && status==1){
            return OAResult.ok(400,"任务已开始,无法重新开始");
        }
        if(oldstatus==1 && status==3){
            return OAResult.ok(400,"任务未开始,无法结束");
        }
        task.setStatus(status);
        int rows=taskMapper.updateByPrimaryKey(task);
        if(rows==1){
            return OAResult.ok(200,"任务状态已更改");
        }
        return OAResult.ok(400,"任务状态更改失败");
    }
}
