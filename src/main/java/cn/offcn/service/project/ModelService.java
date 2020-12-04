package cn.offcn.service.project;

import cn.offcn.entity.Module;
import cn.offcn.utils.OAResult;

import java.util.List;

public interface ModelService {

    /**
     * 保存module
     * @param module
     * @return
     */
    public OAResult saveModel(Module module);


    /**
     * 根据需求分析id获取模块
     * @param analysisId
     * @return
     */
    public List<Module> getModelByAnalysis(int analysisId);
}
