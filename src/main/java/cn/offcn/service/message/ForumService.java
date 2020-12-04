package cn.offcn.service.message;

import cn.offcn.entity.Evaluate;
import cn.offcn.entity.Forumpost;
import cn.offcn.utils.OAResult;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ForumService {

    /**
     * 添加帖子
     * @param forumpost
     * @return
     */
    public void addForumpost(Forumpost forumpost);

    /**
     * 显示登陆者的帖子
     * @param eid
     * @return
     */
    public List<Forumpost> showForumByEid(int eid);

    /**
     * 通过帖子id获取帖子的信息
     * @param forumid
     * @return
     */
    public Forumpost getForumpostByFroumId(int forumid);

    /**
     * 在首页显示前9条数据
     * @param flag
     * @return
     */
    public List<Forumpost> forumpostTop9(int flag);

    /**
     * 评论
     * @param evaluate
     */
    public void addEvaluate(Evaluate evaluate);

    public List<Forumpost> showYi(int eid);
}
