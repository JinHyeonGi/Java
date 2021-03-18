package JIn.java.exam06;

public class MultiClientThread extends Thread {
	private MultiClient me;

	public MultiClientThread(MultiClient mc) {
		this.me = me;
	}

	public void run() {
		String message = null;
		String[] receivedMsg = null;
		boolean isStop = false;
		while (!isStop) {
			try {
				message = (String) me.getOis().readObject();
				receivedMsg = message.split("#");
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			System.out.println(receivedMsg[0] + "," + receivedMsg[1]);
			if (receivedMsg[1].equals("exit")) {
				if (receivedMsg[0].equals(me.getld())) {
					me.exit();
				} else {
					me.getJta().append(receivedMsg[0] + "님이 종료 하셨습니다." + System.getProperty("line.separator"));
					me.getJta().setCaretPosition(me.getJta().getDocument().getLength());
				}
			} else {
				me.getJta().append(receivedMsg[0] + " : " + receivedMsg[1] + System.getProperty("line.separator"));
				me.getJta().setCaretPosition(me.getJta().getDocument().getLength());
			}
		}
	}
}
