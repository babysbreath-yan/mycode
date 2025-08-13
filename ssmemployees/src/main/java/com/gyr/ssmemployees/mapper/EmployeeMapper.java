package com.gyr.ssmemployees.mapper;

import com.gyr.ssmemployees.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 查询员工列表的信息
     * @return
     */
    public List<Employee> getEmployeesList();

    /**
     * 根据在职状态查询员工列表的信息
     * @param jobId
     * @return
     */
    public List<Employee> getEmployeesByJob(@Param("jobId") String jobId);

    /**
     * 添加员工的信息
     * @param employee
     * @return
     */
    public int insertEmployee(Employee employee);

    /**
     * 根据员工的ID查询员工的信息
     * @param id
     * @return
     */
    public Employee getEmployeeById(@Param("id") Integer id);
    /**
     * 修改员工的信息
     * @param employee
     * @return
     */
    public int updateEmployee(Employee employee);

    /**
     * 根据ID删除员工的信息
     * @param id
     * @return
     */
    public int deleteEmployeeById(@Param("id") Integer id);

    /**
     * 批量删除员工列表
     * @param id
     */
    public void deleteEmployees(@Param("id") List<Integer> id);
}

