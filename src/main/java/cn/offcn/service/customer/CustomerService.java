package cn.offcn.service.customer;

import cn.offcn.entity.Customer;
import cn.offcn.utils.OAResult;
import cn.offcn.utils.PageView;

import java.util.List;

public interface CustomerService {

    /**
     * 添加客户
     * @param customer
     * @return
     */
    public OAResult addCustomer(Customer customer);

    /**
     * 分页查询,按条件查询
     * @param currentPage
     * @param pageSize
     * @param keyword
     * @param searchCondition
     * @param orderby
     * @return
     */
    public PageView<Customer> queryCustomer(int currentPage,int pageSize,String keyword,int searchCondition,int orderby);

    /**
     * 通过id查询客户
     * @param id
     * @return
     */
    public Customer queryCustomerById(int id);


    /**
     * 更新客户信息
     * @param customer
     * @return
     */
    public OAResult updateCustomer(Customer customer);

    /**
     * 查询全部客户
     * @return
     */
    public List<Customer> getAllCustomers();
}
