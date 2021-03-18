package JIn.java.exam10;

import java.io.*;

public class FileWriterEx {
	public static void main(String[] args) {
		FileWriter writer = null;
		try {
			// 파일에 한 문자 단위로 기록할수 있는 File Writer객체생성
			writer = new FileWriter("D:/song.txt");	// 덮어 쓰기
			// writer는 문자열을 바로 기록할 수 있다.
			String str = "학교종이 땡땡땡 어서 모이자";
			writer.write(str);
			// 한 글자 단위로 읽고 쓸수 있는 Reader, Writer계열의
			// 스트림은 내부적으로 버퍼를 내장하고 있다.
			// 내장된 버퍼는 버퍼가 가득 채워 질 때에만 스트림을 통해
			// 내보낸다. flushO는 버퍼가 가득차지 않아도 비우게 한다.
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
