package cn.offcn.service.duibiao;

import cn.offcn.entity.Datacollect;
import cn.offcn.entity.Indexvalue;
import cn.offcn.utils.OAResult;

import java.util.List;

public interface DuiBiaoService {

    public List<Datacollect> getInfoGroup();
    public List<Datacollect> getInfoBydacname(String dacname);
    public Datacollect getOneByCname(Datacollect datacollect);
    public Datacollect geOneByDaid(Integer daid);
    public OAResult saveIndexValueInfo(Indexvalue indexvalue);
    public List<Datacollect> showDatacollect();
    public List<Indexvalue> showIndexvalue();
}
