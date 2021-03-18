package JIn.java.exam03;

import java.awt.*;
import java.applet.*;

public class ImageApplet extends Applet {
	private Image im;

	public void init() {
		setLayout(new BorderLayout());
		im = getImage(getCodeBase(), "image/yunajpg");
//getDocumentBase() : html문서 위치
//getCodeBaseO : applet class파일 위치 
	}

	public void paint(Graphics g) {
		g.drawImage(im, 30, 40, 250, 360, this);
	}
}