package com.mybatis;

import com.mybatis.bean.Emp;
import com.mybatis.mapper.CacheMapper;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author bin
 * @date 2022-12-09-11:09
 */
public class CacheTest {

    /**
     * mybatis的一级缓存
     *  mybatis的一级缓存是 sqlSession 级别的
     *  通过同一个 sqlSession 查询的数据会被缓存，再次查询会从缓存中获取
     *  一级缓存默认开启
     *  一级缓存失效的 4 种情况
     *  1. 不同的 sqlSession 对应不同的一级缓存
     *  2. 同一个 sqlSession 但是查询条件不同
     *  3. 同一个 sqlSession 的两次查询期间 执行了任何一次 增删改 操作
     *  4. 同一个 sqlSession 的两次查询期间 手动清空了缓存 sqlSession.clearCache();
     */

    /**
     * mybatis的二级缓存
     *  mybatis的二级缓存是 SqlSessionFactory 级别的，即通过同一个 SqlSessionFactory 所获取的 sqlSession 对象
     *  查询的数据会被缓存，在通过同一个 SqlSessionFactory 所获取的 sqlSession 查询相同的数据会从缓存种获取
     *
     * mybatis的二级缓存开启条件
     *  1. 在核心配置文件中，设置全局属性 cacheEnabled = "true" 默认为 true 不需要设置
     *  2. 在映射文件(CacheMapper.xml)中设置标签 <cache/>
     *  3. 二级缓存必须在 sqlSession 关闭或提交后有效
     *  4. 查询的数据所转换的实体类类型必须 实现序列化接口
     *
     * 使用二级缓存失效的情况
     *  两次查询间执行了任何一次 增删改 操作，会使 一级和二级缓存都失效
     */

    @Test
    /**
     * 缓存命中顺序 -> 优先查询二级缓存，再查询一级缓存，最后查询数据库
     * 测试二级缓存
     * List<Emp> getEmpByEmpId(@Param("empId") Integer empId);
     */
    public void testCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
        List<Emp> list1 = mapper1.getEmpByEmpId(1);
        System.out.println(list1);

        sqlSession.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        List<Emp> list2 = mapper2.getEmpByEmpId(1);
        System.out.println(list2);
    }

    @Test
    /*List<Emp> getEmpByEmpId(@Param("empId") Integer empId);*/
    public void testGetEmpByEmpId() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);

        List<Emp> list1 = mapper1.getEmpByEmpId(1);
        System.out.println("--------------");
        System.out.println(list1);

        List<Emp> list2 = mapper1.getEmpByEmpId(1);
        System.out.println("--------------");
        System.out.println(list2);

        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        List<Emp> list3 = mapper2.getEmpByEmpId(1);
        System.out.println("--------------");
        System.out.println(list3);

        sqlSession1.close();
        sqlSession2.close();
    }

    /**
     * 缓存获取的 bug
     */
    @Test
    public void testCacheBug() throws InterruptedException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);

        List<Emp> list1 = mapper.getEmpByEmpId(15);
        System.out.println("--------------");
        System.out.println(list1);

        // 插入新数据
        /*Emp emp1 = new Emp(null, null, 20, "男");
        Emp emp2 = new Emp(null, "滨", 24, "男");
        List<Emp> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        Integer i = mapper.insertMoreEmp(list);*/

        Integer result = mapper.changeEmpByEmpId(15);
        System.out.println("result " + result);

        // 此时这里已经重新查询了的
        List<Emp> list2 = mapper.getEmpByEmpId(15);
        System.out.println("--------------");
        System.out.println(list1);

        sqlSession.close();

    }
}
