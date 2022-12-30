package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-29-17:02
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployee();

        System.out.println("list " + list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public PageInfo<Employee> getAllEmployeePage(@PathVariable("pageNum") Integer pageNum) {

        PageInfo<Employee> employeePage = employeeService.getEmployeePage(pageNum);

        System.out.println("employeePage " + employeePage);

        return employeePage;
    }
}
