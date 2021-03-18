package JIn.java.exam06;
class ThreadSub extends Thread {
	public void run() {
		for (char ch = 'A'; ch <= 'z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class ThreadEx1 {
	public static void main(String[] ar) {
		ThreadSub ts = new ThreadSub();
		ts.start();
		for (int i = 1; i < 60; i++) {
			System.out.println(i);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
		}
	}
}
