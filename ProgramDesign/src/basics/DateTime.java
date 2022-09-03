package basics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK8之前的 Java中的日期类
 * 1.System类中的 currentTimeMillis
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar 
 */

public class DateTime {
	
	public static void main(String[] args) throws ParseException {
//		返回1970年1月1日0时0分0秒到现在的时间戳 java.lang.System
		long time = System.currentTimeMillis();
		System.out.println(time);
		
//		Date的偏移量是1900年 月份从0开始
		Date date = new Date();
		System.out.println("Date: " + date.toString());
		System.out.println("Date: " + date.getTime());
		
//		将java的Date转化成数据库的Date
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		System.out.println("sql.Date: " + date2.toString());
		System.out.println("----------------");
		
//		SimpleDateFormat
		SimpleDateFormat f1 = new SimpleDateFormat();
		System.out.println("SimpleDateFormat: " + f1.format(date));
		
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(f2.format(date));
		
		Date s2 = f2.parse("2022-06-08 04:08:01"); // 会抛出异常
		System.out.println(s2);
		
		System.out.println("----------------");
		
		Calendar calendar = Calendar.getInstance();
		
//		get
//		获取这个月的第几天
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
//		set
		
//		add
		
//		getTime
//		日历类 -> Date
		Date d1 = calendar.getTime();
		System.out.println(d1);
		
//		setTime
//		Date -> 日历类
		Date d2 = new Date();
		calendar.setTime(d2);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
	}
}
