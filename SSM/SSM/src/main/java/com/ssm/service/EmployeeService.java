package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-29-17:10
 */
public interface EmployeeService {

    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
