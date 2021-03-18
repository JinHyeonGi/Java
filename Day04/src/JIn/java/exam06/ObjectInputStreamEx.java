package JIn.java.exam06;
import java.io.*;

import JIn.java.common.Data;

public class ObjectInputStreamEx {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
//파일에 저장된 객체를 읽어들이기 위해 
//ObjectlnputStream 객체 생성
			ois = new ObjectInputStream(new FileInputStream("D:/obj.sav"));
//ObjectlnputStream은 스트림으로부터
//읽어들인 직렬화된 객체를
//역직렬화해서 객체를 생성할 수 있다.
//역직렬화할때 필요한 클래스 파일을 찾지 못할 경우 
//ClassNotFoundException을 발생 시 킨 다.
			Data data = (Data) ois.readObject();
			System.out.println("번호 : " + data.getNo());
			System.out.println("이름 : " + data.getName());
			System.out.println("메일 : " + data.getMail());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
