package JIn.java.exam01;

import java.io.*;
import java.net.*;

public class UnicastClient {
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	BufferedReader keyboard = null;

	public UnicastClient() {
		try {
//소켓 생성
			socket = new Socket("localhost", 5000);
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결할 수 없습니다.");
			System.exit(0);
		}
		try {
//Keyboard 와 연결된 스트림 얻기
			keyboard = new BufferedReader(new InputStreamReader(System.in));
//socket 으로부터 Stream 얻기
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//서버와 메세지 주고 받기
			while (true) {
//키보드 입력내용 읽기
				System.out.print("전송 메시지 : ");
				String msg = keyboard.readLine();
//메세지 서버로 전송
				bw.write(msg + "\n");
				bw.flush();
//서버가 전송한 메세지 수신
				String getMsg = br.readLine();
				System.out.println("수신 메시지 : " + getMsg);
			}
		} catch (IOException e) {
			System.out.println("서버와의 연결이 끊어졌습니다.");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new UnicastClient();
	}
}
