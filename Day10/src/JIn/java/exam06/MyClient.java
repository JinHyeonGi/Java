package JIn.java.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	private Socket socket = null;
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private BufferedReader keyboard = null;

	public MyClient() {
		try {
			socket = new Socket("localhost", 5000);// 3. 서버에 접속시도
			System.out.println("서버 접속 성공~~~");
		} catch (UnknownHostException ue) {
			System.err.println("해당 서버를 찾을 수 없음");
			System.exit(0);
		} catch (IOException e) {
			System.err.println("서버접속 실패");
			System.exit(0);
		}

		try {
			// 4. 얻어진 소켓으로부터 스트림 추출
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 부터 입력

			while (true) {
				System.out.print("전송할 메세지 : ");
				String message = keyboard.readLine(); // 클라이언트 입력대기

				bw.write(message + "\n"); // 5. 클라이언트가 메시지를 전송
				bw.flush();

				// 8. 서버가 보내온 메시지를 확인한다.
				String recieveMessage = br.readLine();
				System.out.println("서버에게 받은 메시지 : " + recieveMessage);

				if (recieveMessage.equals("exit")) {
					System.out.println("통신을 종료합니다.");
					break;
				}
			}
			System.out.println("서버와의 연결이 끊어졌습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {// 9. 자원들 close()
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
				if (keyboard != null)
					keyboard.close();
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
		new MyClient();
	}
}