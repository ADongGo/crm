package cn.offcn.service.project;

import cn.offcn.entity.Analysis;
import cn.offcn.utils.OAResult;

import java.util.List;

public interface AnalysisService {

    /**
     * 添加需求分析
     * @param analysis
     * @return
     */
    public OAResult saveAnalysis(Analysis analysis);

    /**
     * 获取所有的需求分析
     * @return
     */
    public List<Analysis> getAllAnalysis();

    /**
     * 通过id获取analysis
     * @param id
     * @return
     */
    public Analysis getAnalysisById(int id);
}
