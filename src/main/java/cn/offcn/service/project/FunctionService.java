package cn.offcn.service.project;

import cn.offcn.entity.Function;
import cn.offcn.utils.OAResult;

import java.util.List;

public interface FunctionService {

    /**
     * 添加功能
     * @param function
     * @return
     */
    public OAResult saveFunction(Function function);

    /**
     * 根据模块获取功能
     * @param moduleId
     * @return
     */
    public List<Function> getFunctionsByNoTask(int moduleId);
}
