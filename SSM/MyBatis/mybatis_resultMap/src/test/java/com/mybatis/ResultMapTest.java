package com.mybatis;

import com.mybatis.bean.Dept;
import com.mybatis.bean.Emp;
import com.mybatis.mapper.DeptMapper;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author bin
 * @date 2022-12-08-10:03
 */
public class ResultMapTest {
    @Test
    /*List<Emp> getEmpByEmpId(@Param("empId") Integer empId);*/
    public void testGetEmpByEmpId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> list = mapper.getEmpByEmpId(1);

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list);
    }

    @Test
    /*Emp getEmpByDeptId(@Param("deptId") Integer deptId);*/
    public void testGetEmpByDeptId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> list = mapper.getEmpByDeptId(1);

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list);
    }

    /**
     * 关联查询所有
     */
    @Test
    /*List<Emp> getEmpAndDept();*/
    public void testGetEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> list = mapper.getEmpAndDept();

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list);
    }

    /**
     * 根据 EmpId 查询并关联
     */
    @Test
    /*Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);*/
    public void testGetEmpAndDeptByEmpId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp list = mapper.getEmpAndDeptByEmpId(1);

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list.getEmpName());
    }

    @Test
    /*Dept getDeptByDeptId(@Param("deptId") Integer deptId);*/
    public void testGetDeptByDeptId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        Dept list = mapper.getDeptByDeptId(2);

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list);
    }

    @Test
    /*Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);*/
    public void testGetDeptAndEmpByDeptId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        Dept list = mapper.getDeptAndEmpByDeptId(1);

        sqlSession.close();
        System.out.println("--------------");
        System.out.println(list);
    }
}
