package JIn.java.exam05;

import java.io.*;
/**
 * 존재하는 Text파일에 필요한 내용을 입력하는 코드
 * (중복입력은 불가)
 * (전에 실행한 내용은 마지막에 실행한 내용으로 작성되면서 삭제된다)
 */
public class FileOutputStreamEx {

	public static void main(String arg[]) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("D://Study//Java//fileout.txt");
			String message = "Hello FileOutputStream!!1";
			fos.write(message.getBytes());
			fos.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}
}