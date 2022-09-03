package basics;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Java8DateTime {
	public static void main(String[] args) {
		/**
		 * LocalDate, LocalTime
		 * LocalDateTime
		 *
		 */
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println("localDate  " + localDate);
		System.out.println("localTime  " + localTime);
		System.out.println("localDateTime  " + localDateTime);
		
		System.out.println(localDateTime.getDayOfMonth());
		System.out.println(localDateTime.getDayOfWeek());
		System.out.println(localDateTime.getMonth());
		System.out.println(localDateTime.getMonthValue());
		System.out.println(localDateTime.getMinute());
		
		/**
		 * Instant 瞬时
		 */
//		默认获取0时区的时间
		Instant instant = Instant.now();
		System.out.println("instant: " + instant);
		
//		加8个小时变成东8区的
		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
		System.out.println(offsetDateTime);
		
//		获取时间戳 0时区的
		long milli = instant.toEpochMilli();
		System.out.println(milli);
		
		Instant instant1 = Instant.ofEpochMilli(1654745074398L);
		System.out.println(instant1);
		
		/**
		 * DateTimeFormatter 格式化解析日期,时间
		 * 类似于 SimpleDateFormat
		 */
		System.out.println("-------------DateTimeFormatter------------");
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		System.out.println(formatter);
//		格式化, 日期 -> 字符串
		String str = formatter.format(localDateTime);
		System.out.println("Date:  " + localDateTime);
		System.out.println("String:  " + str);
		
//		解析: 字符串 -> 日期
		TemporalAccessor parse = formatter.parse("2022-06-09T14:48:30.9820093");
		System.out.println(parse);

//		重点: 自定义的格式
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		System.out.println(LocalDateTime.now());
		String str4 = formatter3.format(LocalDateTime.now());
		System.out.println("重点格式:  " + str4);
		
	}
}
