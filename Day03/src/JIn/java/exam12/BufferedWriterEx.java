package JIn.java.exam12;

import java.io.*;

public class BufferedWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("D:/hello.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter 테스트입 니 다.");
			bw.newLine();
			bw.write("안녕하세요" + System.getProperty("line.separator"));
			bw.write("반갑습니 다.");
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException ioe) {
			}
			try {
				if (bw != null)
					bw.close();
			} catch (IOException ioe) {
			}
		}
	}
}
