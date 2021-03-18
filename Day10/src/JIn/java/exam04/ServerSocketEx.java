package JIn.java.exam04;

import java.net.*;

public class ServerSocketEx {
	public static void main(String[] args) throws Exception {
//접속자를 받아들이기 위해 ServerSocketOl 필요하다.
		ServerSocket ss = new ServerSocket(3000);
		while (true) {
			Socket s = ss.accept();// 접속자가 발생할 때까지 대기한다.
//접속자의 ip를 알아내기 위한 객체 받기
			InetAddress iaddr = s.getInetAddress();
			String u_ip = iaddr.getHostAddress();
			System.out.println(u_ip + "님 접속");
		} // end while
	}
}
