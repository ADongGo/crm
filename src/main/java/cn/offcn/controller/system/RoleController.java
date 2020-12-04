package cn.offcn.controller.system;

import cn.offcn.entity.Role;
import cn.offcn.entity.RoleSources;
import cn.offcn.service.system.RoleService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/{page}")
    public String forwardPage(@PathVariable("page")String page, @RequestParam(value = "roleid",defaultValue = "0")int roleid, Model model){

        model.addAttribute("roleid",roleid);
        return "system/"+page;
    }

    @ResponseBody
    @RequestMapping("/addRole")
    public OAResult addRole(Role role,String sourcesid){

        return roleService.addRole(role,sourcesid);
    }

    @ResponseBody
    @RequestMapping("/getAllRole")
    public List<Role> getAllRole(){

        return roleService.getAllRole();
    }

    @ResponseBody
    @RequestMapping("/deleteRoleById")
    public OAResult deleteInfo(int roleid){

        return roleService.deleteInfo(roleid);
    }

    @ResponseBody
    @RequestMapping("/showOneRole")
    public Map showOneRole(int roleid){
        Map map=new HashMap();
        Role role = roleService.showOneRole(roleid);
        map.put("role",role);
        List<RoleSources> roleSourcesList=roleService.getSourcesByRoleid(roleid);
        map.put("sourcesId",roleSourcesList);

        return map;
    }

    @ResponseBody
    @RequestMapping("/updateRole")
    public OAResult updateRole(Role role,String sourcesid){

        return roleService.updateRole(role,sourcesid);
    }

    @ResponseBody
    @RequestMapping("/getAllRoleByStatus")
    public List<Role> getAllRoleByStatus(int status){

        return roleService.getAllRoleByStatus(status);
    }
}
