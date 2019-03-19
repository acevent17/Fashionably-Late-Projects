package fashionably.main;

import java.io.File;

import java.util.*;

public class CreateIndexFile {

	private Formatter createFile;

	// Creates file if doesn't exist
	public void openIndexFile() {
		try {

			File createFile = new File("Index.txt");
			createFile.createNewFile();

		} catch (Exception e) {
			System.out.println("Error Creating Index File");
		}
	}

	// Creating datasets within file (DND)
	public void addIndexData() {

		createFile.format("%s %s %s");

	}

	// Closing file
	public void closeIndex() {
		createFile.close();
	}

}
