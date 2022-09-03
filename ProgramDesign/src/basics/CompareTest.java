package basics;

import java.util.Arrays;

public class CompareTest {
	
	/**
	 * 比较器
	 * Comparable
	 * 像String类实现了Comparable接口 并且重写了CompareTo(obj)方法
	 * 重新定义CompareTo方法规则
	 * 	this大于obj 返回正整数
	 * 	this小于obj 返回负整数
	 * 	this等于obj 返回0
	 * 对于自定义类来说,想要实现排序,可以继承Comparable接口,并且重写CompareTo方法 
	 * 
	 * 
	 * Comparator
	 */
	public static void main(String[] args) {
		String[] arr = new String[]{"AA", "CC", "BB", "FF", "DD"};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
