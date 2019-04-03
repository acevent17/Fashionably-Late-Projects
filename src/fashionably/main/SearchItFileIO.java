/*
 * Class dedicated to File Handling and Choosing File functionality of the Search Engine
 * 
 * Changes are displayed below:
 * --Created File writer for Search.txt file.
 *
 * 
 * Current Issues are displayed below:
 * --N/A
 *  
 *  
 * Resolved Issues:
 * --N/A
 * 
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.main;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

//Importing classes from main package 
import fashionably.main.SearchItMaintenance;
//Class to handle file view, file selection, file addition and file deletion. 
//Takes no variables'
//Sends variable type String to method addFileListener in the SearchItTables class

public class SearchItFileIO {

	// Global Variables

	static JFileChooser fileChooser = new JFileChooser(FileSystemView
			.getFileSystemView().getHomeDirectory());

	// Gets path of file
	public static void getPath() {

		// Used by getPath()
		String filePath;
		String fileName;
		long fileDateLong;
		String fileDateString;

		// Selects file
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File selectedFile = fileChooser.getSelectedFile();

		// Gets FileName, FilePath, ModifiedDate
		fileName = selectedFile.getName();
		filePath = selectedFile.getAbsolutePath();
		fileDateLong = selectedFile.lastModified();

		// The format is Month/Day/Year - Hour/Minutes/Seconds
		SimpleDateFormat dateConverter = new SimpleDateFormat(
				"MM/dd/yyyy - hh:mm:ss");
		fileDateString = dateConverter.format(new Date(fileDateLong));

		// Variable sent to class:SerachItTables method:addFileListener with
		// file information
		String[] fileRowInfo = new String[] { fileName, filePath,
				fileDateString };

		// Variable sent to class:SerachItTables method:addFileListener
		SearchItTables.addFileListener(fileRowInfo);

		try
		// Creating a writers necessary for the "Index.txt" file
		(FileWriter writer = new FileWriter("Index.txt", true);
				BufferedWriter buffWrite = new BufferedWriter(writer);
				PrintWriter write = new PrintWriter(buffWrite);) {

			// Writes the name, path, and date to the text file.
			// Saves to the text file, but will overwrite.
			write.print(fileName);
			write.print(",");
			write.print(filePath);
			write.print(",");
			write.println(fileDateString);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try
		// Creating a writers necessary for the "Index.txt" file
		(FileWriter writer = new FileWriter("Search.txt", true);
				BufferedWriter buffWrite = new BufferedWriter(writer);
				PrintWriter write = new PrintWriter(buffWrite);) {

			// Writes the name, path, and date to the text file.
			// Saves to the text file, but will overwrite.
			write.println(fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fileHandler() {
		fileChooser.setAcceptAllFileFilterUsed(false);

		// Shows FileChooserDialog Window
		int returnVal = fileChooser
				.showOpenDialog(SearchItMaintenance.subMaintenanceFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			getPath();

		}
	}
}
