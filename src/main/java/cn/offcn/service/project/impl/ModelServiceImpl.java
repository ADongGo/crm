package cn.offcn.service.project.impl;

import cn.offcn.entity.Module;
import cn.offcn.entity.ModuleExample;
import cn.offcn.mapper.ModuleMapper;
import cn.offcn.service.project.ModelService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public OAResult saveModel(Module module) {

        int insert = moduleMapper.insert(module);

        if(insert==1){
            return OAResult.ok(200,"保存成功");
        }else{
            return OAResult.ok(400,"保存失败");
        }
    }

    @Override
    public List<Module> getModelByAnalysis(int analysisId) {

        ModuleExample moduleExample=new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAnalysisFkEqualTo(analysisId);
        return moduleMapper.selectByExample(moduleExample);
    }
}
