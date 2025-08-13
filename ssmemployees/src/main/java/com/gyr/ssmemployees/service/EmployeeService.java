package com.gyr.ssmemployees.service;

import com.gyr.ssmemployees.pojo.Employee;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface EmployeeService {
    /**
     * 查询员工列表的信息
     * @return
     */
    public List<Employee> getAllEmployees();

    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 每一页显示的条数
     * @return PageInfo对象
     */
    public PageInfo getEmployeesByPage(Integer pageNum, Integer pageSize);

    /**
     * 根据在职状态查询员工列表的信息
     * @param jobId
     * @return
     */
    public List<Employee> getEmployeesByJob(String jobId);
    /**
     * 添加员工的信息
     * @param employee
     * @return
     */
    public int insertEmployee(Employee employee);
    /**
     * 根据ID查询员工的信息
     * @param id
     * @return
     */
    public Employee getEmployeeById(Integer id);
    /**
     * 编辑员工的信息
     * @param employee
     * @return
     */
    public int updateEmployee(Employee employee);
    /**
     * 根据ID删除员工的信息
     * @param id
     * @return
     */
    public int deleteEmployeeById(Integer id);
    /**
     * 批量删除
     * @param
     * @return
     */
    public void deleteEmployees(List<Integer> id);
}
