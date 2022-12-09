package com.mybatis.mapper;

import com.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author bin
 * @date 2022-12-08-9:55
 */
public interface EmpMapper {

    List<Emp> getEmpByEmpId(@Param("empId") Integer empId);

    List<Emp> getEmpByDeptId(@Param("deptId") Integer deptId);

    List<Emp> getEmpAndDept();

    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
}
