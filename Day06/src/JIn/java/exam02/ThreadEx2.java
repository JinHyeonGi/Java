package JIn.java.exam02;
import java.io.*;

class ThreadSub extends Thread {
	private String name;
	private String lastname;

	public ThreadSub(String a, String b, int x) {
		name = a;
		lastname = b;
		setPriority(x);
		setDaemon(true);
	}

	public void run() {
		System.out.println(Thread.activeCount());
		int xx = Thread.activeCount();
		Thread[] th = new Thread[xx];
		Thread.enumerate(th);
		for (int i = 0; i < th.length; i++) {
			System.out.println(
					th[i].getName() + " : " + th[i].getPriority() + " : " + th[i].isDaemon() + " : " + th[i].isAlive());
		}
		while (true) {
			System.out.print("이름" + name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("\t이름2 : " + lastname);
			}
		}
	}
}

public class ThreadEx2 {
	public static void main(String[] ar) {
		ThreadSub ts = new ThreadSub("진현", "기", 1);
		ts.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException ee) {
		}
		ThreadSub ts1 = new ThreadSub("진현", "기", 5);
		ts1.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException ee) {
		}
	}
}
