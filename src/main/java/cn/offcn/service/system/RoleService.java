package cn.offcn.service.system;

import cn.offcn.entity.Role;
import cn.offcn.entity.RoleSources;
import cn.offcn.utils.OAResult;

import java.util.List;

public interface RoleService {

    /**
     * 保存角色的权限
     * @param role
     * @param sourcesid
     * @return
     */
    public OAResult addRole(Role role, String sourcesid);

    /**
     * 页面异步展示角色
     * @return
     */
    public List<Role> getAllRole();

    /**
     * 通过roleid删除角色及其管理
     * @param roleid
     * @return
     */
    public OAResult deleteInfo(int roleid);

    /**
     * 获取role对象
     * @param roleid
     * @return
     */
    public Role showOneRole(int roleid);

    /**
     * 通过roleid获取RoleSources对象
     * @param roleid
     * @return
     */
    public List<RoleSources> getSourcesByRoleid(int roleid);

    /**
     * 更新role
     * @param role
     * @param sourcesid
     * @return
     */
    public OAResult updateRole(Role role,String sourcesid);

    /**
     * 通过状态码获取role
     * @param status
     * @return
     */
    public List<Role> getAllRoleByStatus(int status);
}
