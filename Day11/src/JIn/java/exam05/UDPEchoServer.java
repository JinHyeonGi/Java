package JIn.java.exam05;

import java.net.*;
import java.io.*;

public class UDPEchoServer {
	public UDPEchoServer(int port) {
		try {
			DatagramSocket ds = new DatagramSocket(port);
			while (true) {
				byte buffer[] = new byte[512];
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				System.out.println("ready");
				ds.receive(dp);
				String str = new String(dp.getData());
				System.out.println("수신된 데이터 : " + str);
				InetAddress ia = dp.getAddress();
				port = dp.getPort();
				System.out.println("client ip : " + ia + "， client port : " + port);
				dp = new DatagramPacket(dp.getData(), dp.getData().length, ia, port);
				ds.send(dp);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new UDPEchoServer(3000);
	}
}
