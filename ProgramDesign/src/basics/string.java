package basics;

/**
 * 
 * @Description
 * @author binn
 * @version
 * @date 2022年6月7日下午2:41:50
 *
 */
public class string {
	
	public static void main(String[] args) {
		String s1 = "binn";
		String s2 = "min";
		
		String s3 = s1 + "min";
		String s4 = "binn" + s2;
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3);
		StringBuffer bf1 = new StringBuffer("abc");
		System.out.println(bf1.length());
		
		char[] c1 = new char[5];
		c1[0] = 'b';
		System.out.println(c1.length);
	}
}
