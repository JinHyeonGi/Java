package JIn.java.exam13;

import java.awt.*;

public class FileDialogEx extends Frame {
	FileDialog fd = new FileDialog(this, "내꺼저장", FileDialog.SAVE);
	public FileDialogEx() {
		super("FileDialogEx");
		setSize(300, 200);
		setVisible(true);
		fd.setVisible(true);
		System.out.println(fd.getFile());
		System.out.println(fd.getDirectory());
	}
	public static void main(String[] ar) {
		FileDialogEx fde = new FileDialogEx();
	}
}