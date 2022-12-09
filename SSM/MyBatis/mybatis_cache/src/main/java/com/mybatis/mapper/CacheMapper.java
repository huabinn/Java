package com.mybatis.mapper;

import com.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-09-11:03
 */
public interface CacheMapper {

    List<Emp> getEmpByEmpId(@Param("empId") Integer empId);

    int changeEmpByEmpId(@Param("empId") Integer empId);

    int insertMoreEmp(@Param("emps") List<Emp> emps);

    /*获取所有数据*/
    List<Emp> getAllEmp();
}
