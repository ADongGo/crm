package cn.offcn.service.office;

import cn.offcn.entity.Task;
import cn.offcn.utils.OAResult;

import java.util.List;

public interface TaskService {

    /**
     * 保存任务
     * @param task
     * @return
     */
    public OAResult saveTask(Task task);

    /**
     * 通过员工获取任务
     * @param eid
     * @return
     */
    public List<Task> getTaskByEmployee(int eid);

    /**
     * 获取登录者的task
     * @param eid
     * @return
     */
    public List<Task> getMyTaskEmployee(int eid);

    /**
     * 改变任务状态
     * @param id
     * @param status
     * @return
     */
    public OAResult updateTaskStatus(int id,int status);
}
