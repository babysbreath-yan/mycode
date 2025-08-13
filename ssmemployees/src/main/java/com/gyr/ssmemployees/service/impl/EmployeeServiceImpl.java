package com.gyr.ssmemployees.service.impl;

import com.gyr.ssmemployees.mapper.EmployeeMapper;
import com.gyr.ssmemployees.pojo.Employee;
import com.gyr.ssmemployees.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional //添加事务的注解
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * 查询员工列表的信息
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getEmployeesList();
    }
    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 每一页显示的条数
     * @return PageInfo对象
     */
    @Override
    public PageInfo getEmployeesByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        //查询到所有员工的信息
        List<Employee> employeesList = employeeMapper.getEmployeesList();
        PageInfo<Employee> pageInfo=new PageInfo<Employee>(employeesList);
        return pageInfo;
    }
    /**
     * 根据在职状态查询员工列表的信息
     * @param jobId
     * @return
     */
    @Override
    public List<Employee> getEmployeesByJob(String jobId) {
        return employeeMapper.getEmployeesByJob(jobId);
    }
    /**
     * 添加员工的信息
     * @param employee
     * @return
     */
    @Override
    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }
    /**
     * 根据ID查询员工的信息
     * @param id
     * @return
     */
    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }
    /**
     * 编辑员工的信息
     * @param employee
     * @return
     */
    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }
    /**
     * 根据ID删除员工的信息
     * @param id
     * @return
     */
    @Override
    public int deleteEmployeeById(Integer id) {
        return employeeMapper.deleteEmployeeById(id);
    }

    /**
     * 批量删除
     * @param id
     */
    public void deleteEmployees(List<Integer> id) {
        employeeMapper.deleteEmployees(id);
    }
}
