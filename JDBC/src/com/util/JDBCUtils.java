package com.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 调用数据库工具类
 * @Description
 * @author bin
 * @version
 * @date 2022年10月8日下午5:11:14
 *
 */
public class JDBCUtils {
	
	/**
	 * 连接数据库
	 * @Description
	 * @author bin
	 * @date 2022年11月7日下午4:11:18
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
//		读取配置文件信息
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String diverClass = pros.getProperty("diverClass");
		
		Class.forName(diverClass);

		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	/**
	 * 关闭连接数据库的各种资源
	 * @Description
	 * @author bin
	 * @date 2022年11月7日下午4:11:32
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn, Statement ps) {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
			if(rs != null) rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
