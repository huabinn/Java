package com.mybatis;

import com.mybatis.bean.Emp;
import com.mybatis.mapper.DynamicSQLMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bin
 * @date 2022-12-08-20:00
 */
public class DynamicSQLTest {

    @Test
    /*List<Emp> getEmpByCondition(Emp emp);*/
    public void testGetDeptAndEmpByDeptId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        Emp emp = new Emp(null, null, 20, "男");
//        Emp emp = new Emp();
        List<Emp> list = mapper.getEmpByCondition(emp);

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list);
    }

    @Test
    /*void insertMoreEmp(@Param("emps") List<Emp> emps);*/
    public void testInsertMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        Emp emp1 = new Emp(null, null, 20, "男");
        Emp emp2 = new Emp(null, "滨", 24, "男");
        List<Emp> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        Integer i = mapper.insertMoreEmp(list);

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(i);
    }
}
