package JIn.java.exam02;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class RunTimeApplet extends Applet {
	private static int initnum = 0;
	private static int startnum = 0;
	private static int stopnum = 0;
	private static int paintnum = 0;
	private Label lb = new Label("다음과 같이 실행됩니다.");

	public void init() {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		add("North", lb);
		initnum++;
	}

	public void start() {
		startnum++;
	}

	public void paint(Graphics g) {
		paintnum++;
		g.setFont(new Font("TimeRoman", Font.BOLD, 20));
		g.setColor(Color.black);
		g.drawString("init", 30, 80);
		g.drawString("start", 30, 150);
		g.drawString("paint", 30, 220);
		g.drawString("stop", 30, 290);
//선그리 기
		g.setColor(Color.black);
		g.drawLine(100, 50, 100, 340);
		g.drawLine(100, 340, 380, 340);
//세부눈금 그리기...
		g.setColor(Color.lightGray);
		for (int i = 125; i < 380; i += 25) {
			g.drawLine(i, 50, i, 340);
		}
//막대 그래프 그리기...
//init 그리기..
		g.setColor(Color.red);
		g.fillRect(100, 70, initnum * 25, 30);
//start 그리기..
		g.setColor(Color.green);
		g.fillRect(100, 140, startnum * 25, 30);
//paint 그리기..
		g.setColor(Color.blue);
		g.fillRect(100, 210, paintnum * 25, 30);
//stop 그리기..
		g.setColor(Color.magenta);
		g.fillRect(100, 280, stopnum * 25, 30);
	}

	public void stop() {
		stopnum++;
	}

	public void destroy() {
	}
}
