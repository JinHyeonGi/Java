package JIn.java.exam11;

import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			// 파일로부터 한문자단위로 읽어 올수 있는 FileReader 객체 생성
			reader = new FileReader("D:/song.txt");
			// 스트림을 통해서 읽어들인 유니코드값을 저장할 변수
			int readValue = 0;
			while ((readValue = reader.read()) != -1) {
				System.out.println((char) readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
