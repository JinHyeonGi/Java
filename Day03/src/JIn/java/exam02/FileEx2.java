package JIn.java.exam02;

import java.io.File;
/**
 * 경로 내 폴더와 파일, 파일의 이름, 크기와 나타냄
 */
public class FileEx2 {
	public static void main(String[] args) {
		File directory = new File("D:/");
		if(directory.exists()) {	// D드라이브가 존재하는가
			if(directory.isDirectory()) {
			// 현재 디렉토리내의 모든 파일 디렉토리의 이름 얻기
				String[] fileNameList = directory.list();	// 모든 폴더와 파일을 List형태로 받음
				for(String fileName : fileNameList) {
					File myfile = new File(directory, fileName);
					if(myfile.isFile())
						System.out.println("파일 이름 : " + myfile.getName() + ", 파일 크기 : " + myfile.length() + "byte");
					else
						System.out.println("폴더 이름 : " + myfile.getName());
				}
			}
		}
	}
}