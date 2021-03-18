package JIn.java.exam01;
import java.util.*;

public class ScannerEx1 {
	public static void main(String[] args) {
		System.out.print("입력 : ");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.printf("스캔 : %d", number);
		scan.close();
	}
}
