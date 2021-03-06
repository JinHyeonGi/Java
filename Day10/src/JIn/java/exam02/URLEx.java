package JIn.java.exam02;

import java.io.*;
import java.net.*;

public class URLEx {
	public static void main(String[] args) {
		//URL(uniform resource locator)에 대한 정보를 가지고 있는 클래스
		BufferedReader br = null;
		try {
			URL url = new URL("http：//www.daum.net/index.html");
			//url객체로부터 프로토콜，호스트명，포트번호，
			//자원의 경로, 쿼리스트링등을 얻을 수 있다.
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("포트번호 : " + url.getPort());
			System.out.println("경로 : " + url.getPath());
			System.out.println("파일 : " + url.getFile());
			// url이 가르키는 자원과 연결된 InputStream개설
			// InputStream is = url.openStream();
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (MalformedURLException e) {
			// 잘못된 url인 경우 MalformedURLException을 발생한다.
			e.printStackTrace();
		} catch (IOException e) {
			// openStream()은 IOException을 발생한다.
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
			}
		}
	}
}