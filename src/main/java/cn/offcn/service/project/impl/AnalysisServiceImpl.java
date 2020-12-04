package cn.offcn.service.project.impl;

import cn.offcn.entity.Analysis;
import cn.offcn.entity.AnalysisExample;
import cn.offcn.mapper.AnalysisMapper;
import cn.offcn.service.project.AnalysisService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisMapper analysisMapper;

    @Override
    public OAResult saveAnalysis(Analysis analysis) {

        analysis.setAddtime(new Date());
        analysis.setUpdatetime(new Date());
        int insert = analysisMapper.insert(analysis);

        if(insert==1){
            return OAResult.ok(200,"保存成功");
        }else{
            return OAResult.ok(400,"保存失败");
        }
    }

    @Override
    public List<Analysis> getAllAnalysis() {

        return analysisMapper.selectByExample(new AnalysisExample());
    }

    @Override
    public Analysis getAnalysisById(int id) {

        return analysisMapper.selectByPrimaryKey(id);
    }
}
