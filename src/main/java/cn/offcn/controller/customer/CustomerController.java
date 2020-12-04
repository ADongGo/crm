package cn.offcn.controller.customer;

import cn.offcn.entity.Customer;
import cn.offcn.service.customer.CustomerService;
import cn.offcn.utils.OAResult;
import cn.offcn.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cus")
public class CustomerController {

    @Value("${pageSize}")
    private int pageSize;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/{page}")
    public String forwordPage(@PathVariable("page")String page){

        return "customer/"+page;
    }

    @ResponseBody
    @RequestMapping("/add")
    public OAResult addCustomer(Customer customer){
     System.out.print("------------");
        return customerService.addCustomer(customer);
    }

    @ResponseBody
    @RequestMapping("/queryCustomer")
    public PageView<Customer> queryCustomer(int currentPage,String keyword,
                                            @RequestParam(value = "searchCondition",defaultValue = "0") int searchCondition,
                                            @RequestParam(value = "orderby",defaultValue = "0") int orderby){

        return customerService.queryCustomer(currentPage,pageSize,keyword,searchCondition,orderby);
    }

    @RequestMapping("/queryCustomerById/{page}")
    public String  queryCustomerById(int id, @PathVariable("page") String page, Model model){
        Customer customer = customerService.queryCustomerById(id);
        model.addAttribute("customer",customer);

        return "customer/"+page;
    }

    @ResponseBody
    @RequestMapping("/update")
    public OAResult updateCustomer(Customer customer){

        return customerService.updateCustomer(customer);
    }

    @ResponseBody
    @RequestMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){


        return customerService.getAllCustomers();
    }
}
