package fashionably.main;

import java.io.*;
import java.util.*;

public class ReadFile {

	private Scanner fileReader;

	// Opens Index File
	public void openFile() {
		try {
			fileReader = new Scanner(new File("Index.txt"));

		} catch (Exception e) {
			System.out.println("Could not find file");
		}
	}

	// Reads next line in Index File till EOF
	public void readFile() {
		while (fileReader.hasNext()) {
			String fileName = fileReader.next();
			String filePath = fileReader.next();
			String fileDateString = fileReader.next();

			System.out.printf("%s %s %s\n", fileName, filePath, fileDateString);

		}
	}

	// Closes Index File
	public void closeFile() {
		fileReader.close();
	}

}
