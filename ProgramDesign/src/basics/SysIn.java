package basics;
import java.io.*;
import java.util.*;

/**
 * 
 * @Description
 * @author binn
 * @version
 * @date 2022年4月6日上午11:50:37
 *
 */
public class SysIn {
	public static void main(String[] args) throws IOException {
		/*
			BufferedReader buf;
			String str;
			buf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("请输入字符串：");
			str = buf.readLine();
			System.out.println("您输入的字符串是：" + str);
		*/
		String s1;
		Scanner reader = new Scanner(System.in);
		System.out.print("请输入字符串：");
		s1 = reader.next();
		System.out.println("您输入的字符串是：" + s1);
		reader.close();
	}
}
