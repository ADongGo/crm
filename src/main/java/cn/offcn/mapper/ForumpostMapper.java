package cn.offcn.mapper;

import cn.offcn.entity.Forumpost;
import cn.offcn.entity.ForumpostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumpostMapper {
    int countByExample(ForumpostExample example);

    int deleteByExample(ForumpostExample example);

    int deleteByPrimaryKey(Integer forumid);

    int insert(Forumpost record);

    int insertSelective(Forumpost record);

    List<Forumpost> selectByExampleWithBLOBs(ForumpostExample example);

    List<Forumpost> selectByExample(ForumpostExample example);

    Forumpost selectByPrimaryKey(Integer forumid);

    int updateByExampleSelective(@Param("record") Forumpost record, @Param("example") ForumpostExample example);

    int updateByExampleWithBLOBs(@Param("record") Forumpost record, @Param("example") ForumpostExample example);

    int updateByExample(@Param("record") Forumpost record, @Param("example") ForumpostExample example);

    int updateByPrimaryKeySelective(Forumpost record);

    int updateByPrimaryKeyWithBLOBs(Forumpost record);

    int updateByPrimaryKey(Forumpost record);
}