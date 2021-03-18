package JIn.java.exam03;

import java.io.*;
import java.net.*;

public class URLConnectionEx {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			URL url = new URL("http://www.daum.net/index.html");
			URLConnection uc = url.openConnection();
			uc.connect();
			String str = null;
			br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
