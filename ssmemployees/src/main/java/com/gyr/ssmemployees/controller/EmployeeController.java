package com.gyr.ssmemployees.controller;

import com.gyr.ssmemployees.pojo.Employee;
import com.gyr.ssmemployees.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     *
     * @param model  参数，保存数据对象，底层是4个作用域
     * @return
     */
    @RequestMapping("/getEmployeeList")
    public String getEmployeeList(Model model){
        List<Employee> list = employeeService.getAllEmployees();
        model.addAttribute("employees",list);
        return "staff_List";
    }

    /**
     * 分页查询员工的信息
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("/getEmployeesByPage")
    public String getEmployeesByPage(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                     Model model) {
        PageInfo pageInfo = employeeService.getEmployeesByPage(pageNum, 3);
        //将pageNum当前页存储到Model对象中
        model.addAttribute("pageNum",pageNum);
        //将pageSize每页显示的条数存储到Model对象中
        model.addAttribute("pageSize",pageSize);
        //将pageInfo对象存储到Model对象中
        model.addAttribute("pageInfo",pageInfo);
        return "staff_List";
    }

    /**
     * 根据在职状态查询员工列表的信息
     * @param jobId
     * @param model
     * @return
     */
    @RequestMapping("/getEmployeesByJob")
    public String  getEmployeesByJob(String jobId,Model model){
        List<Employee> employeesByJob = employeeService.getEmployeesByJob(jobId);
        System.out.println("employeesByJob"+employeesByJob);
        model.addAttribute("employeesByJob",employeesByJob);
        return "staff_List";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/getAddPage")
    public String getAddPage(){
        return "add_Staff";
    }
    /**
     * 添加员工的信息
     * @param employee
     * @return
     */
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee){
        int i = employeeService.insertEmployee(employee);
        System.out.println("i"+i);
        if (i==1){
            return "redirect:/employee/getEmployeesByPage.do";
        }else{
            System.out.println("添加失败，请重新添加");
            return "redirect:/employee/getAddPage.do";
        }

    }
    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getEmployeeUpdateByPage")
    public String getEmployeeUpdateByPage(Integer id,Model model){
        System.out.println("id:"+id);
        Employee employeeById = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employeeById);
        return "edit_Staff";
    }
    /**
     * 根据ID修改员工的信息
     * @param employee
     * @return
     */
    @RequestMapping("/updateEmployee")
    public String updateEmployee(Integer id,Employee employee){
        employee.setId(id);
        int i = employeeService.updateEmployee(employee);
        if(i==1){
            System.out.println("修改成功");
            return "redirect:/employee/getEmployeesByPage.do";
        }else{
            System.out.println("修改失败");
            return "redirect:/employee/getEmployeeUpdateByPage.do";
        }
    }
    /**
     * 根据ID删除员工的信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(Integer id){
        int i = employeeService.deleteEmployeeById(id);
        if(i==1){
            System.out.println("删除成功");

        }
        return "redirect:/employee/getEmployeesByPage.do";
    }

    /**
     * 批量删除
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/deleteEmployees")
    public String deleteEmployees(@RequestParam("id") List<Integer> id, Model model) {
        employeeService.deleteEmployees(id);
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "redirect:/employee/getEmployeesByPage.do"; // 返回员工列表页面
    }
}
