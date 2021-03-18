package JIn.java.exam05;

import java.awt.*;
import java.applet.*;

public class AudioEx extends Applet {
	private AudioClip audio;
	private Label lb;

	public void init() {
		lb = new Label("음악이 들리나요", Label.CENTER);
		lb.setFont(new Font("굴림체", Font.BOLD, 40));
		setLayout(new BorderLayout());
		add("North", lb);
		try {
			audio = getAudioClip(getCodeBase(), "spacemusic.au");
		} catch (Exception e) {
		}
	}

	public void start() {
		try {
			audio.loop();
		} catch (Exception e) {
		}
	}
}