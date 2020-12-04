package cn.offcn.service.office;

import cn.offcn.entity.Notice;

import java.util.List;

public interface NoticeService {

    /**
     *保存Notice
     * @param notice
     */
    public void addNotice(Notice notice);

    /**
     * 获取notice列表
     * @return
     */
    public List<Notice> getNotice();

    /**
     * 获取指定数量的notice列表到main页面
     * @param flag
     * @return
     */
    public List<Notice> getNoticesByFlag(int flag);

    /**
     * 通过nid获取notice展示在main页面的弹窗上
     * @param nid
     * @return
     */
    public Notice getNoticeByNid(int nid);
}
