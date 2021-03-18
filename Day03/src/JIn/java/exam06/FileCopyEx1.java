package JIn.java.exam06;

import java.io.*;
/**
 * 존재하는 파일을 복사하는 코드
 */
public class FileCopyEx1 {
	public static void main(String[] args) {
		System.out.println("파일복사 시작");
		long start = System.currentTimeMillis();	// 현재 시간 측정
		
		FileInputStream src = null;
		FileOutputStream dest = null;
		try {
			// 원본 파일을 읽기 위한 FilelnputStream 객체 생성
			src = new FileInputStream(new File("D:\\Study\\Java\\(1) Source Code.zip"));
			// 복사본 파일을 생성하기 위한 FileOutputStream 객체생성
			dest = new FileOutputStream(new File("D:\\Study\\Java\\(2) Source Code.zip"));
			// FilelnputStream을 통해서 읽어들인 값을 저장할 변수
			int readValue = 0;
			// FilelnputStream의 read()메소드를 통해서 읽어들인 값을 H readValue에 저장
			while ((readValue = src.read()) != -1) {
				// readValue에 저장된 값을 FileOutputStread의 write()
				// 메소드를 통해서 파일에 기록
				dest.write(readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dest != null) {
					dest.close();
				}
			} catch (IOException e) {
			}
			try {
				if (src != null) {
					src.close();
				}
			} catch (IOException e) {
			}
		}
		
		long end = System.currentTimeMillis();
		long copyTime = (end - start);
		System.out.println("걸린 시간 : " + copyTime + "밀리 초");
	}
}