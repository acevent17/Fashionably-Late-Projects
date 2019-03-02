/*
 * Class dedicated to File Handling and Choosing File functionality of the Search Engine
 * 
 * Changes are displayed below:
 * --Changed fileChooser to a Global Variable
 * --Added a get and display method for the file path
 * --TBA
 * --added variable to the getPath method
 * added compatability between getPath and SearchItTables classes.
 * 
 * Current Issues are displayed below:
 * --added the return values to the getpath method, might have to delete later. 
 *  
 * Resolved Issues:
 *  --Created get and display method for the file path 
 *  --All file extensions now show
 *  --TBA
 *  
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.main;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

//Importing classes from main package 
import fashionably.main.SearchItMaintenance;

//Class to handle file view, file selection, file addition and file deletion. 
//Takes no variables
//Sends variable type String to method addFileListener in the SearchItTables class
//as of right now it only sends file path
//future implementation should send a String[] with file name, path and date modified
public class SearchItFileIO {

	// Global Variable for FileChooser (Needed to get and display as separate
	// method)
	static JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

	public static void fileHandler() {
		fileChooser.setAcceptAllFileFilterUsed(false);

		// Shows FileChooserDialog Window
		int returnVal = fileChooser.showOpenDialog(SearchItMaintenance.subMaintenanceFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			// Gets and displays the File Path
			getPath();
		}

	}

	// Variable sent to class:SerachItTables method:addFileListener with file
	// information
	public static String fileToAddInfo;

	// Method in charge of getting file path
	// future implementations would be ALL file information required
	public static void getPath() {

		// Gets path of file
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File selectedFile = fileChooser.getSelectedFile();

		fileToAddInfo = selectedFile.getAbsolutePath();

		// Displays path of file
		System.out.println(fileToAddInfo);

		// Variable sent to SerachItTables class, method addFileListener for
		// when the Dynamic Table works
		SearchItTables.addFileListener(fileToAddInfo);

	}

}
