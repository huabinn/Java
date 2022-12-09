package com.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.bean.Emp;
import com.mybatis.mapper.CacheMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bin
 * @date 2022-12-09-16:52
 */
public class PageLimitTest {

    // 分页插件测试
    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);

        // 在查询功能开始之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> list = mapper.getAllEmp();

        // 查询功能之后可以获取本页的相关数据 pageInfo的数据比 page的多
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);

        System.out.println("--------------");
        System.out.println(pageInfo);
        list.forEach(System.out::println);

        sqlSession.close();
    }
}
