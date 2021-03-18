package JIn.java.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	private Socket socket = null;
	private BufferedReader br = null;
	private BufferedWriter bw = null;

	public MyServer() {
		// 1. 서버소켓을 생성
		ServerSocket server = null;
		try {
			server = new ServerSocket(5000);
		} catch (IOException e) {
			System.err.println("해당 포트가 사용중입니다.");
			System.exit(0);
		}

		try {

			System.out.println("서버 준비됨^^");
			socket = server.accept(); // 2. 서버에서 청취 : 클라이언트의 접속을 대기

			// 안해도 되지만 보통 접속내용을 로그로 남긴다.
			InetAddress ia = socket.getInetAddress();
			String clientIp = ia.getHostAddress();
			System.out.println(clientIp + " 님이 접속함.^^.");

			// 4. 얻어진 소켓으로부터 스트림 추출
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				// 6. 클라이언트 메시지를 받는다.
				String message = br.readLine();
				System.out.println("클라이언트가 보낸 메시지 : " + message);

				// 7. 클라이언트에게 응답메시지를 보낸다.
				bw.write(message + "\n");
				bw.flush();

				if (message.equals("exit")) {
					System.out.println("클라이언트와의 연결을 종료하겠습니다.");
					break;
				}
			}
			System.out.println("서버를 종료합니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {// 9. 모든 자원을 close()
			try {
				if (bw != null)
					bw.close();
			} catch (IOException ioe) {
			}
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
			}
			try {
				if (socket != null)
					socket.close();
			} catch (IOException ioe) {
			}
		}

	}

	public static void main(String[] args) {
		new MyServer();
	}
}