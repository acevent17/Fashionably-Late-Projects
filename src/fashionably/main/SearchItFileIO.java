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

public class SearchItFileIO {
	// Global Variable for FileChooser (Needed to get and display as separate
	// method)
	static JFileChooser fileChooser = new JFileChooser(FileSystemView
			.getFileSystemView().getHomeDirectory());

	public static void fileHandler() {
		fileChooser.setAcceptAllFileFilterUsed(false);

		// Shows FileChooserDialog Window
		int returnVal = fileChooser
				.showOpenDialog(SearchItMaintenance.subMaintenanceFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			// Gets and displays the File Path
			getPath();
		}

	}
	
	public static String pathTrial1;

	public static void getPath() {
		// Gets path of file
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File selectedFile = fileChooser.getSelectedFile();
		

		// Displays path of file

		System.out.println(selectedFile.getAbsolutePath());
		
		//Variable sent to SrachItTables class, method addFileListener for
		//when the Dynamic Table works
		pathTrial1 = selectedFile.getAbsolutePath(); 
		//SearchItTables.addFileListener(pathTrial1);
		
	}
}
