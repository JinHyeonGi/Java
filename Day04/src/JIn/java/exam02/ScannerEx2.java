package JIn.java.exam02;
import java.util.*;
import java.io.*;

public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("D:\\scan.txt"));
			while (scan.hasNextDouble()) {
				System.out.printf("스캔  double : %,.2f %n", scan.nextDouble());
			}
			scan.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
		}
	}
}