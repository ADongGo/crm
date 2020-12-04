package cn.offcn.service.office.impl;

import cn.offcn.entity.Baoxiao;
import cn.offcn.entity.BaoxiaoExample;
import cn.offcn.mapper.BaoxiaoMapper;
import cn.offcn.mapper.EmployeeMapper;
import cn.offcn.service.office.BaoxiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BaoxiaoServiceImpl implements BaoxiaoService {

    @Autowired
    private BaoxiaoMapper baoxiaoMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @Override
    public void saveBaoxiao(Baoxiao baoxiao,int eid) {

        baoxiao.setBxid(UUID.randomUUID().toString());
        baoxiao.setEmpFk(eid);
        baoxiao.setBxstatus(1);
        baoxiaoMapper.insert(baoxiao);
    }

    @Override
    public List<Baoxiao> queryBaoxiao(int eid) {

        BaoxiaoExample baoxiaoExample=new BaoxiaoExample();
        BaoxiaoExample.Criteria criteria = baoxiaoExample.createCriteria();
        criteria.andEmpFkEqualTo(eid);

        return baoxiaoMapper.selectByExample(baoxiaoExample);
    }

    @Override
    public List<Baoxiao> getBaoxiaoByStatus(int bxstatus) {
        
        BaoxiaoExample baoxiaoExample=new BaoxiaoExample();
        BaoxiaoExample.Criteria criteria = baoxiaoExample.createCriteria();
        criteria.andBxstatusEqualTo(bxstatus);
        List<Baoxiao> baoxiaos = baoxiaoMapper.selectByExample(baoxiaoExample);
        for(Baoxiao baoxiao:baoxiaos){
            baoxiao.setEmployee(employeeMapper.selectByPrimaryKey(baoxiao.getEmpFk()));
        }
        return baoxiaos;
    }

    @Override
    public Baoxiao getBaoXiaoByBxid(String bxid) {

        return baoxiaoMapper.selectByPrimaryKey(bxid);
    }

    @Override
    public void approveBaoxiao(String bxid,int bxstatus,String result,int eid) {
        Baoxiao baoxiao=baoxiaoMapper.selectByPrimaryKey(bxid);
        baoxiao.setCaiwuFk(eid);
        baoxiao.setBxstatus(bxstatus);
        baoxiao.setResult(result);
        baoxiao.setShenpidate(new Date());
        baoxiaoMapper.updateByPrimaryKey(baoxiao);
    }

    public void updateBaoxiaoByBxid(Baoxiao baoxiao){
        Baoxiao oldBaoxiao= baoxiaoMapper.selectByPrimaryKey(baoxiao.getBxid());
        baoxiao.setShenpidate(oldBaoxiao.getShenpidate());
        baoxiao.setResult(oldBaoxiao.getResult());
        baoxiao.setCaiwuFk(oldBaoxiao.getCaiwuFk());
        baoxiao.setEmpFk(oldBaoxiao.getEmpFk());
        baoxiaoMapper.updateByPrimaryKey(baoxiao);
    }
}
