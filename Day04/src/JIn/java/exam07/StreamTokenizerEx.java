package JIn.java.exam07;
import java.io.*;

public class StreamTokenizerEx {
	public static void main(String[] args) {
		BufferedReader br = null;
		StreamTokenizer st = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("D:/streamToken.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);
			pw.println(10000);
			pw.println("안녕하세요");
			pw.println("stdio@hanmail.net");
			pw.println("I am a instructor");
			pw.println("~`!@#");
			br = new BufferedReader(new FileReader("D:\\streamToken.txt"));
			st = new StreamTokenizer(br);
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				switch (st.ttype) {
				case StreamTokenizer.TT_WORD:
					System.out.println("Word => " + st.sval);
					break;
				case StreamTokenizer.TT_NUMBER:
					System.out.println("Number => " + (int) st.nval);
					break;
				default:
					System.out.println("No word, No number =>" + (char) st.ttype);
					break;
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
				if (bw != null)
					bw.close();
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}