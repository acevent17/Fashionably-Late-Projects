/*
 * Class dedicated to File Handling and Choosing File functionality of the Search Engine
 * 
 * Changes are displayed below:
 * --Changed fileChooser to a Global Variable
 * --Added a get and display method for the file path
 * --added variable to the getPath method
 * --added compatibility between getPath and SearchItTables classes.
 * --completed the file info variable shared between method:getPath and method:addFileListener
 * --completed formating for date
 * --removed testing codes and comments
 *
 * 
 * Current Issues are displayed below:
 * -- JSON needs to provide a new line to the .txt file
 * -- JSON needs to pre load the .txt file
 * -- JSON needs to read the .txt file  
 *  
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

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.json.*;


//Importing classes from main package 
import fashionably.main.SearchItMaintenance;

//Class to handle file view, file selection, file addition and file deletion. 
//Takes no variables
//Sends variable type String to method addFileListener in the SearchItTables class
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

	// Variables used by method:getPath
	public static String filePath;
	public static String fileName;
	public static long fileDateLong;
	public static String fileDateString;

	
	// team: please review and make sure all methods used here should be within the
	// getPath()
	// or if they should be moved to the fileHandler
	//
	// Method in charge of getting file path
	public static void getPath() {

		// file selector
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		File selectedFile = fileChooser.getSelectedFile();

		// gets file name, path and date
		fileName = selectedFile.getName();
		filePath = selectedFile.getAbsolutePath();
		fileDateLong = selectedFile.lastModified();

		// date converter
		// The format is Day/Month/Year - Hour/Minutes/Seconds
		SimpleDateFormat dateConverter = new SimpleDateFormat("dd//MM/yyy - hh:mm:ss");
		fileDateString = dateConverter.format(new Date(fileDateLong));

		// Variable sent to class:SerachItTables method:addFileListener with file
		// information
		String[] fileRowInfo = new String[] { fileName, filePath, fileDateString };

		// Variable sent to class:SerachItTables method:addFileListener
		SearchItTables.addFileListener(fileRowInfo);
		
		
		// - delete if not used after next commit
		// JSON set up not needed right now 
		// JSONObject jsonObject = new JSONObject();
		
		//  could be used later 
		 //jsonObject.put("Name", "blank");
	
		//JSONArray list = new JSONArray();
		//list.add(fileName);
		//list.add(filePath);
		//list.add(fileDateLong);
		
		//jsonObject.put("courses", list);
		
		//try(FileWriter file = new FileWriter("JSON.txt"))
		//{
			//file.write(jsonObject.toString());
			//file.flush();
			//file.close();
		//}
		//catch(IOException e)
		//{
			//e.printStackTrace();
		//}
		
		// Writes to JSON.txt file
		try 
			(FileWriter writer = new FileWriter("JSON.txt", true);
			BufferedWriter buffWrite = new BufferedWriter(writer);
			PrintWriter p = new PrintWriter(buffWrite);) {
			
			 //Writes the name, path, and date to the text file. 
			 //Saves to the text file, but will over write.
			p.print(fileName);
			p.print(";");
			p.print(filePath);
			p.print(";");
			p.println(fileDateString);  
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
