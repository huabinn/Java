package com.mybatis.mapper;

import com.mybatis.bean.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author bin
 * @date 2022-12-08-9:57
 */
public interface DeptMapper {

    Dept getDeptByDeptId(@Param("deptId") Integer deptId);

    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);
}
