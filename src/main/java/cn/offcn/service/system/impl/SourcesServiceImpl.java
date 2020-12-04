package cn.offcn.service.system.impl;

import cn.offcn.entity.*;
import cn.offcn.mapper.RoleSourcesMapper;
import cn.offcn.mapper.SourcesMapper;
import cn.offcn.service.system.SourcesService;
import cn.offcn.utils.JsonUtils;
import cn.offcn.utils.OAResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class SourcesServiceImpl implements SourcesService {

    @Autowired
    private SourcesMapper sourcesMapper;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private RoleSourcesMapper roleSourcesMapper;

    @Override
    public List<Sources> getRootSources(int pid) {

        SourcesExample sourcesExample=new SourcesExample();
        SourcesExample.Criteria criteria = sourcesExample.createCriteria();
        criteria.andPidEqualTo(pid);
        List<Sources> sourcesList = sourcesMapper.selectByExample(sourcesExample);
        for(Sources sources:sourcesList){
            List<Sources> sourcess = getRootSources(sources.getId());
            sources.setChildren(sourcess);
        }
        return sourcesList;
    }

    public OAResult addSources(Sources sources){
        int insert = sourcesMapper.insert(sources);
        //清除redis里数据
        Jedis jedis = jedisPool.getResource();
        jedis.del("permission");
        jedis.close();
        if(insert==1){
            return OAResult.ok(200,"添加成功");
        }else{
            return OAResult.ok(400,"添加失败");
        }
    }

    public Sources getOneSource(int id){

        return sourcesMapper.selectByPrimaryKey(id);
    }

    public OAResult updateSource(Sources sources){

        int i = sourcesMapper.updateByPrimaryKey(sources);
        if(i==1){
            return OAResult.ok(200,"更新成功");
        }else{
            return OAResult.ok(400,"更新失败");
        }
    }

    public OAResult deleteSourcesById(int id){

        RoleSourcesExample roleSourcesExample=new RoleSourcesExample();
        RoleSourcesExample.Criteria criteria = roleSourcesExample.createCriteria();
        criteria.andSidEqualTo(id);
        roleSourcesMapper.deleteByExample(roleSourcesExample);

        //清除redis里数据
        Jedis jedis = jedisPool.getResource();
        jedis.del("permission");
        jedis.close();

        int i = sourcesMapper.deleteByPrimaryKey(id);
        if(i==1){
            return OAResult.ok(200,"删除成功");
        }else{
            return OAResult.ok(400,"删除失败");
        }
    }

    @Override
    public List<Sources> getSourcesByEmployee(int eid, int pid,String username) {
        //从缓存中找数据
        Jedis jedis = jedisPool.getResource();
        try{
            String jsonData = jedis.hget("permission", username);
            if(StringUtils.isNotBlank(jsonData)){
                System.out.println("从缓存中找到");
                jedis.close();
                return JsonUtils.jsonToList(jsonData,Sources.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //查表
        List<Sources> sourcesList=getCurrentEmployeeSources(eid,pid);
        //往redis中缓存
        try{
            jedis.hset("permission",username,JsonUtils.objectToJson(sourcesList));
            System.out.println("把权限写入缓存");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sourcesList;
    }
    public List<Sources> getCurrentEmployeeSources(int eid,int pid){
        List<Sources> sourcesList= sourcesMapper.getSourcesByEmployee(eid,pid);
        for(Sources sources : sourcesList){
            sources.setChildren(getCurrentEmployeeSources(eid,sources.getId()));
        }
        return sourcesList;
    }
}
