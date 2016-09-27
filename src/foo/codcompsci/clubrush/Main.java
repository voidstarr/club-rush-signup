package foo.codcompsci.clubrush;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	static String homeDir = System.getProperty("user.home");
	static String pathToList = homeDir + File.pathSeparator + "cod-comp-sci-new-members.txt";
	static File newMembers = new File(pathToList);

	public static void main(String[] args) {

		Window window = new Window();
		window.frame.setVisible(true);
	}

	public static void memberEntered(String name, String email) {
		try (FileWriter fw = new FileWriter(newMembers, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(name + " : " + email);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
