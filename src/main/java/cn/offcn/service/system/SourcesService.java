package cn.offcn.service.system;

import cn.offcn.entity.Sources;
import cn.offcn.utils.OAResult;

import java.util.List;

public interface SourcesService {

    /**
     * 获取所有sources
     * @param pid
     * @return
     */
    public List<Sources> getRootSources(int pid);

    /**
     * 添加sources
     * @param sources
     * @return
     */
    public OAResult addSources(Sources sources);

    /**
     * 在编辑页面显示sources
     * @param id
     * @return
     */
    public Sources getOneSource(int id);

    /**
     * 更新sources
     * @param sources
     * @return
     */
    public OAResult updateSource(Sources sources);

    /**
     * 删除sources
     * @param id
     * @return
     */
    public OAResult deleteSourcesById(int id);

    /**
     * 通过员工获取他的权限
     * @param eid
     * @param pid
     * @return
     */
    public List<Sources> getSourcesByEmployee(int eid, int pid,String username);

}
