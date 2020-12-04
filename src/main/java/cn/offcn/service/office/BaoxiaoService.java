package cn.offcn.service.office;

import cn.offcn.entity.Baoxiao;

import java.util.List;

public interface BaoxiaoService {

    /**
     * 保存我的报销
     * @param baoxiao
     */
    public void saveBaoxiao(Baoxiao baoxiao,int eid);

    /**
     * 通过eid查询报销列表
     * @param eid
     * @return
     */
    public List<Baoxiao> queryBaoxiao(int eid);

    /**
     * 通过状态获取报销列表
     * @param bxstatus
     * @return
     */
    public List<Baoxiao> getBaoxiaoByStatus(int bxstatus);

    /**
     * 通过bxid获取baoxiao对象
     * @param bxid
     * @return
     */
    public Baoxiao getBaoXiaoByBxid(String bxid);


    /**
     * 审批
     * @param
     */
    public void approveBaoxiao(String bxid,int bxstatus,String result,int eid);

    /**
     * 更新我的审批
     * @param baoxiao
     */
    public void updateBaoxiaoByBxid(Baoxiao baoxiao);
}
