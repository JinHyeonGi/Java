package JIn.java.exam03;

import java.io.*;
/**
 * 파일의 존재유무 확인 및 파일 이동, 삭제, 생성 & 폴더의 생성 등을 실행하는 코드
 */
public class FileEx3 {
	public static void main(String[] args) throws IOException {

		// 파일 생성 (D드라이브에 newFile이라는 text파일을 생성
		File f1 = new File("D:/newFile.txt");
		if (f1.exists()) {
			System.out.println("파일 이름:" + f1.getName());
		} else {
			if (f1.createNewFile()) {
				System.out.println("새로운 파일을 만들었습니다.");
			}
		}
		
		// 디렉토리 생성
		File f2 = new File("D:/newDirectory");
		if (!f2.exists()) {
			f2.mkdir();
		} else {
			System.out.println("디렉토리 이름:" + f2.getPath());
		}
		
		// 파일 혹은 디렉토리 삭제
		File f3 = new File("D:\\Study\\Java/text.txt");
		if (f3.exists()) {
			f3.delete();	System.out.println(f3.getName() + "라는 이름의 파일를 삭제하였습니다.");
		} else {
			System.out.println(f3.getName() + "라는 이름의 파일이 존재하지 않습니다..");
		}
		
		// 파일 혹은 디렉토리 이름 변경
		File src = new File("D:/newFile.txt");
		File dest = new File("D:/newDirectory/dest.txt");
		File dest2 = new File("D:/newDirectory/desc2.txt");
		if (src.exists()) {
			if(src.renameTo(dest)) {
				System.out.println("dest.txt로 이동 성공");
			} else {
				System.out.println("dest.txt로 이동 실패");
			}
			if(src.renameTo(dest2)) {
				System.out.println("dest2.txt로 이동 성공");
			} else {
				System.out.println("dest2.txt로 이동 실패");
			}
		}
		if (f2.isDirectory()) { // 디렉토리의 목록을 출력함.
			String dir[] = f2.list();
			System.out.println("\n\n Dir Content:============\n");
			for (String dirs : dir) {
				System.out.println("dirs : " + dirs);
			}
		}
	}
}