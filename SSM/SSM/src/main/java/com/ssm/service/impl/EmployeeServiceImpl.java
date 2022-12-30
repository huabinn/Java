package com.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;
import com.ssm.mapper.EmployeeMapper;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-29-17:11
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        // 在查询功能开始之前开启分页功能
        Page<Object> page = PageHelper.startPage(pageNum, 4);

        List<Employee> list = employeeMapper.getAllEmployee();
        // 查询功能之后可以获取本页的相关数据 pageInfo的数据比 page的多
        PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);

        return pageInfo;
    }
}
