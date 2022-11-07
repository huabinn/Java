package com.preparedStatement.curd;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.util.JDBCUtils;
import com.bean.*;
/**
 * 
 * @Description
 * @author bin
 * @version
 * @date 2022年10月9日上午10:42:54
 *
 */
public class PreparedStatementUpdate {
	
	/**
	 * 通用数据库增删改函数测试
	 * @Description
	 * @author bin
	 * @date 2022年11月7日下午4:08:05
	 */
	@Test
	public void testInsert() {
		String sql = "insert into customers(name, email, birth) values(?, ?, ?)";
		update(sql, "binn", "binn@qq.com", "2000-10-01");
//		String sql = "delete from customers where id = ?";
//		update(sql, 20);
	}
	
	/**
	 * 调用数据库的查询操作测试
	 * @Description
	 * @author bin
	 * @date 2022年11月7日下午4:08:41
	 */
	@Test
	public void testGetForList() {
		String sql = "select id,name,email from customers where id < ?";
		List<Customer> list = getForList(Customer.class, sql, 23);
//		System.out.println(list);
		list.forEach(System.out::println);
	}
	
	/**
	 * 通用数据库增删改函数
	 * @Description
	 * @author bin
	 * @date 2022年10月9日上午10:58:07
	 * @param sql
	 * @param args
	 */

	public void update(String sql, Object ...args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
//			获取数据库连接
			conn = JDBCUtils.getConnection();
//			预编译sql语句
			ps = conn.prepareStatement(sql);
//			填充占位符
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
//			执行
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			关闭资源
			JDBCUtils.closeResource(conn, ps);
		}
	}

	/**
	 * 调用数据库的查询操作
	 * @Description
	 * @author bin
	 * @date 2022年10月9日下午3:58:22
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T> getForList(Class<T> clazz, String sql, Object ...args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
//			获取数据库连接
			conn = JDBCUtils.getConnection();
//			预编译sql语句
			ps = conn.prepareStatement(sql);
//			填充占位符
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
//			执行
			rs = ps.executeQuery();
//			获取元数据
			ResultSetMetaData rsmd = rs.getMetaData();
//			获取结果集列数
			int columnCount = rsmd.getColumnCount();
//			创建集合对象
			ArrayList<T> list = new ArrayList<T>();
//			整合查询结果
			while(rs.next()) {
				T t = clazz.getDeclaredConstructor().newInstance();
				
				for(int i=0; i<columnCount; i++) {
//					获取列值
					Object columnValue = rs.getObject(i + 1);
//					获取列名
					String columnLabel = rsmd.getColumnLabel(i + 1);
					
					Field field = t.getClass().getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			关闭资源
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}
}
