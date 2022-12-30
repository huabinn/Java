package com.ssm.mapper;

import com.ssm.bean.Employee;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-29-17:21
 */
public interface EmployeeMapper {
    // 查询所有的员工信息
    List<Employee> getAllEmployee();
}
