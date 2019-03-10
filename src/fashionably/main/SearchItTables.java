/*
 * Class dedicated to table functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for table functionality
 * --Added compatibility between getPath and SearchItTables classes.
 * --Made the table be more dynamic
 * --Completed compatibility between "class:SearchItFileIO method:getPath" and "class:SearchItTables method:addFileListener"
 * --Remove File button is functioning, however not in the complete indended way
 * 
 * 
 * 
 * 
 * Current Issues are displayed below:
 *  
 * --Currently I am using String[] and Object[], however, Mr. Pollock recommends the use of List instead,
 *    this should be changed soon. // This is probably not necessary, we can keep working on the project and see.
 * 
 * --Remove button clears the ENTIRE JSON.txt file
 * 
 * 
 * 
 * 
 * Resolved Issues:
 * --Table has an initialized Table Model* ([Default]) *(tableModel)
 * --Data of rows is now an initialized variable* ([data1, data2]) *(null)
 * --Data in rows on columns are not setting from the FileChooser* *(Class: SearchItFileIO)
 * --All the row information to work and be added to the table
 * --Removed place holders: filename, pathname, and date.
 * --Remove button is semi-functioning
 * 
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.main;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SearchItTables {

	// table variable
	// it was made static to be able to edit table
	static JTable indexTable;

	// variable used by tableDataGatherer
	public static String[][] fileInfo = {};

	// This is the method that adds the row
	// receives variable:fileToAddInfoTable from class:SearchItFileIO
	// method:getPath
	public static void addFileListener(String[] fileToAddInfoTable) {

		TableModel tableModelVar = indexTable.getModel();
		DefaultTableModel addRowObject = (DefaultTableModel) tableModelVar;
		addRowObject.addRow(fileToAddInfoTable);

		/*
		 * //boolean variable and if statement that will activate if the user
		 * adds or deletes any files from the database boolean
		 * secondIndexBoolean = IndexChecker.IndexChangesCheck();
		 * if(secondIndexBoolean = true) { update index file }else{ do nothing?
		 * }
		 */
	}

	/*
	 * REMOVE FILE SECTION -- Basic framework created Currently clears entire
	 * text file when remove button is pressed.
	 * 
	 * -- Ideas: Set an ID to each entry or set a counter to the lines in the
	 * textfile to allow use to specify which file to remove.
	 * 
	 * -- To be Added: Popup confirmation dialog (YES / NO / CANCEL)
	 */
	
	public static void removeFileIndex(int fileToAddInfoTable)
			throws FileNotFoundException {

		TableModel tableModelDetach = indexTable.getModel();
		DefaultTableModel removeRowObject = (DefaultTableModel) tableModelDetach;
		
		try {
		int SelectedRowIndex = indexTable.getSelectedRow();
		removeRowObject.removeRow(SelectedRowIndex);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		PrintWriter writer = new PrintWriter("JSON.txt");
		writer.print("");
		writer.close();
	}

	// Dynamic Table Code
	// receives variable:dataBaseArray from method:createTable
	// returns variable:rowInfo type:String[][] with table data.
	public static String[][] tableDataGatherer(String[][] dataBaseArray) {

		int arrayLength = dataBaseArray.length;
		String[][] rowInfo = new String[arrayLength][3];

		for (int i = 0; i < dataBaseArray.length; i++) {
			for (int j = 0; j < 3; j++) {
				rowInfo[i][j] = dataBaseArray[i][j];
			}
		}

		return rowInfo;
	}

	// Create Table
	public static Component createTable() {

		// Column Names
		String[] columns = new String[] { "File Name", "File Path",
				"Date Modified" };

		// Change column String to Object to comply with DefaultTableModel
		// parameters
		Object[] columnObject = columns;

		Object[][] row = tableDataGatherer(fileInfo);

		// Creating Table
		DefaultTableModel tableModel = new DefaultTableModel(row, columnObject);
		indexTable = new JTable(tableModel);
		
		
		String read = ";";

		try {
			BufferedReader reader = getFileReader();

			// First line will contain the column names

			String line = null;

			while ((line = reader.readLine()) != null) {

				tableModel.addRow(line.split(read));

			}

			reader.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		// Table Sizing and table variable return to SearchItMaintenance Class
		indexTable.setPreferredScrollableViewportSize(indexTable.getPreferredSize());

		
		return indexTable;

	}

	private static BufferedReader getFileReader() throws FileNotFoundException {

		BufferedReader reader = new BufferedReader(new FileReader("JSON.txt"));

		return reader;
	}
	
}
