package cn.offcn.service.project;

import cn.offcn.entity.Project;
import cn.offcn.utils.OAResult;
import cn.offcn.utils.PageView;

import java.util.List;

public interface ProjectService {


    /**
     * 添加项目
     * @param project
     * @return
     */
    public OAResult addProject(Project project);


    /**
     * 获取所有项目
     * @return
     */
    public List<Project> getAllProject();


    /**
     * 获取没有需求分析的项目
     * @return
     */
    public List<Project> getAllProjectByNoNeed();


    /**
     * 获取有需求分析的项目
     * @return
     */
    public List<Project> getAllProjectByNeed();


    /**
     * 查询所有有模块的项目
     * @return
     */
    public List<Project> getAllProjectByModule();

    public List<Project> getProjectByFunctionAndEid(int eid);

    /**
     * 通过id获取项目
     * @return
     */
    public Project getProjectById(int pid);

    /**
     * 分页展示项目
     * @param currentPage
     * @param searchC
     * @param keyword
     * @param orderby
     * @return
     */
    public PageView<Project> showProject(int currentPage,int searchC,String keyword,int orderby,int pageSize);
}
