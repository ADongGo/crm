package cn.offcn.service.customer.impl;


import cn.offcn.entity.Customer;
import cn.offcn.entity.CustomerExample;
import cn.offcn.mapper.CustomerMapper;
import cn.offcn.service.customer.CustomerService;
import cn.offcn.utils.OAResult;
import cn.offcn.utils.PageView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public OAResult addCustomer(Customer customer) {
        customer.setAddtime(new Date());
        int i = customerMapper.insert(customer);
        if(i==1){
            return OAResult.ok(200,"添加成功");
        }else{
            return OAResult.ok(400,"添加失败");
        }
    }


    @Override
    public PageView<Customer> queryCustomer(int currentPage, int pageSize, String keyword, int searchCondition, int orderby) {

        PageHelper.startPage(currentPage,pageSize);
        CustomerExample customerExample=new CustomerExample();

        if(searchCondition!=0){
            if(searchCondition==1){
                if (StringUtils.isNotBlank(keyword)){
                    CustomerExample.Criteria criteria = customerExample.createCriteria();
                    criteria.andComnameLike("%"+keyword+"%");
                }
            }
            if(searchCondition==2){
                if (StringUtils.isNotBlank(keyword)){
                    CustomerExample.Criteria criteria = customerExample.createCriteria();
                    criteria.andCompanypersonLike("%"+keyword+"%");
                }
            }
        }
        if(orderby!=0){
            if (orderby==1){
                customerExample.setOrderByClause("addtime ASC");
            }
            if (orderby==2){
                customerExample.setOrderByClause("addtime DESC");
            }
        }

        List<Customer> customers = customerMapper.selectByExample(customerExample);
        PageInfo<Customer> pageInfo=new PageInfo<>(customers);
        PageView<Customer> pageView=new PageView<>(currentPage,pageSize);
        pageView.setTotalrecords(pageInfo.getTotal());
        pageView.setRecords(pageInfo.getList());
        return pageView;
    }

    @Override
    public Customer queryCustomerById(int id) {

        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public OAResult updateCustomer(Customer customer) {

        int i = customerMapper.updateByPrimaryKey(customer);

        if(i==1){
            return OAResult.ok(200,"编辑成功");
        }else{
            return  OAResult.ok(400,"编辑失败");
        }
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerMapper.selectByExample(new CustomerExample());
    }
}
