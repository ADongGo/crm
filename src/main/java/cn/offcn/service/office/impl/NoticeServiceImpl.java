package cn.offcn.service.office.impl;

import cn.offcn.entity.Notice;
import cn.offcn.entity.NoticeExample;
import cn.offcn.mapper.NoticeMapper;
import cn.offcn.service.office.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin.dom.exception.NoModificationAllowedException;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public void addNotice(Notice notice) {

        notice.setNdate(new Date());
        noticeMapper.insert(notice);
    }

    @Override
    public List<Notice> getNotice() {

        NoticeExample noticeExample=new NoticeExample();
        noticeExample.setOrderByClause("ndate DESC");
        return noticeMapper.selectByExampleWithBLOBs(noticeExample);
    }

    @Override
    public List<Notice> getNoticesByFlag(int flag) {

        NoticeExample noticeExample=new NoticeExample();
        noticeExample.setOrderByClause("ndate DESC limit 0,"+flag);
        return noticeMapper.selectByExampleWithBLOBs(noticeExample);
    }

    @Override
    public Notice getNoticeByNid(int nid) {

        return noticeMapper.selectByPrimaryKey(nid);
    }
}
