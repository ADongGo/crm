package cn.offcn.service.project.impl;

import cn.offcn.entity.Function;
import cn.offcn.mapper.FunctionMapper;
import cn.offcn.service.project.FunctionService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    @Override
    public OAResult saveFunction(Function function) {

        int insert = functionMapper.insert(function);
        if(insert==1){
            return OAResult.ok(200,"保存成功");
        }else{
            return OAResult.ok(400,"保存失败");
        }
    }

    @Override
    public List<Function> getFunctionsByNoTask(int moduleId) {


        return functionMapper.getFunctionsByNoTask(moduleId);
    }
}
