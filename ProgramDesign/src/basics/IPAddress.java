package basics;

import java.net.*;

public class IPAddress {
	InetAddress myIPAdress = null;
	InetAddress myServer = null;
	
	public static void main(String[] args) {
		IPAddress search = new IPAddress();
		System.out.println("主机的IP地址为：" + search.myIP());
		System.out.println("服务器的IP地址为：" + search.serverIP());
	}
	
	public InetAddress myIP() {
		try {
			myIPAdress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return (myIPAdress);
	}
	
	public InetAddress serverIP() {
		try {
			myServer = InetAddress.getByName("www.bilibili.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return (myServer);
	}
}
