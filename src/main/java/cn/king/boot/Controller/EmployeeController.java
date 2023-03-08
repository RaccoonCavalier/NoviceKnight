package cn.king.boot.Controller;

import cn.king.boot.Service.EmployeeService;
import cn.king.boot.pojo.Employee;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //加载localhost:8080地址会直接跳转到首页
    @RequestMapping("/")
    private String returnIndex(){
        return "index";
    }

    //返回的是没有分页的员工列表
    @GetMapping("/employee/employee_list")
    public String getEmplyeeList(Model model){
        List<Employee> EmployeeList = employeeService.list(null);
        model.addAttribute("EmployeeList" , EmployeeList);
        return "employee/employee_list";
    }

    //返回的是使用分页插件进行显示的员工列表
    //pn是获取请求数据中页码，没有就默认是1
    @GetMapping("/employee/employee_pageList")
    public String getEmployeePageList(@RequestParam(value = "pn" , defaultValue = "1") Integer pn , Model model){
        //pn是页码，第二属性size就是一页显示多少条数据
        //这里显示15条，刚好填满整个页面
        Page<Employee> employeePage = new Page<Employee>(pn, 15);
        Page<Employee> page = employeeService.page(employeePage);
        model.addAttribute("page" , page);
        return "employee/employee_pageList";
    }

    //根据id删除数据库中的单条数据
    //并返回原有的页面，重定向原本的页面
    //@DeleteMapping("/employee/employee_delete/{id}")
    @RequestMapping(value = "/employee/employee_delete/{id}" , method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable(value = "id") Integer id){
        employeeService.removeById(id);
        return "redirect:/employee/employee_pageList";
    }
}
