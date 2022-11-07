package com.connection;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import org.junit.Test;

/**
 * 连接数据库方式
 * @Description
 * @author bin
 * @version
 * @date 2022年9月28日下午4:36:11
 *
 */
public class ConnectionTest {
//	方式1
	@Test
	public void testConnection1() throws SQLException {

		Driver driver = new com.mysql.cj.jdbc.Driver();
		// test 数据库名字
		String url = "jdbc:mysql://localhost:3306/test";
//		String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Asia/Shanghai";
//		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";

		// 将用户名和密码封装到 Properties
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "binn");

		Connection conn = driver.connect(url, info);

		System.out.println(conn);
	}
	
//	方式2
	@Test
	public void testConnection2() throws Exception {
		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		
		String url = "jdbc:mysql://localhost:3306/test";
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "binn");

		Connection conn = driver.connect(url, info);

		System.out.println(conn);
	}
//	方式3
	@Test
	public void testConnection3() throws Exception {
		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "binn";
		
//		注册驱动
		DriverManager.registerDriver(driver);

		Connection conn = DriverManager.getConnection(url, user, password);

		System.out.println(conn);
	}
//	方式4
	@Test
	public void testConnection4() throws Exception {

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "binn";
		
//		Class.forName自动注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, user, password);

		System.out.println(conn);
	}
	
//	方式5
	@Test
	public void testConnection5() throws Exception {
//		InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties pros = new Properties();
		pros.load(is);
		
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String diverClass = pros.getProperty("diverClass");
		
		Class.forName(diverClass);

		Connection conn = DriverManager.getConnection(url, user, password);

		System.out.println(conn);
		
	}
	
}