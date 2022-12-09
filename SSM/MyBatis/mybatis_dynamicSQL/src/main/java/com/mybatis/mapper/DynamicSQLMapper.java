package com.mybatis.mapper;

import com.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-08-19:49
 */
public interface DynamicSQLMapper {

    /**
     * 根据条件查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    int insertMoreEmp(@Param("emps") List<Emp> emps);
}
