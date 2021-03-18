package JIn.java.exam04;

import java.io.*;
/**
 * 파일명(경로)을 입력, 파일의 내용을 출력하는 프로그램
 */
public class FileInputStreamEx {
	public static void main(String arg[]) {
		FileInputStream fis = null;
		byte _read[] = new byte[100];	// 읽을 거
		byte console[] = new byte[100];	// 파일명 입력받을 거
		try {
			System.out.print("파일명 : ");
			System.in.read(console);
			String file = new String(console).trim();	// 입력 받은 걸 문자열로 변경
			// String - > byte[] : str.getBytes()
			fis = new FileInputStream(file);
			// fis.read(_read, 0, _read.length);
			// System.out.println(new String(_read).trim());
			int readByte = -1;
			while((readByte = fis.read()) != -1) {
				System.out.print((char)readByte);
			}	// 전체를 출력
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
