/*
 * Class dedicated to table functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for table functionality
 * --TBA
 * --added compatibility between getPath and SearchItTables classes.
 * --made the table be more dynamic
 * --completed compatibility between "class:SearchItFileIO method:getPath" and "class:SearchItTables method:addFileListener"
 * --
 * 
 * 
 * 
 * Current Issues are displayed below:
 * --what is the line "public static final String tableModel = null;"
 * used for??
 * --the dummy table needs to be deleted before implementing database. 
 * 
 * 
 * Resolved Issues:
 * --Table has an initialized Table Model* ([Default]) *(tableModel)
 * --Data of rows is now an initialized variable* ([data1, data2]) *(null)
 * --TBA
 * --Data in rows on columns are not setting from the FileChooser* *(Class: SearchItFileIO)
 *-- got all the row information to work and be added to the table
 * 
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.main;

import java.awt.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SearchItTables {

	@TeamRviewRequired
	// if this line is commented out, there are no issues
	// is this required?
	public static final String tableModel = null;

	// table variable
	// it was made static to be able to edit table
	static JTable indexTable;

	// dummy-temporary database
	// variable used by tableDataGatherer
	public static String[][] fileInfo = { { "FileName1", "FilePath1", "FileDate1" },
			{ "FileName2", "FilePath2", "FileDate2" }, { "FileName3", "FilePath3", "FileDate3" },
			{ "FileName4", "FilePath4", "FileDate4" }, { "FileName5", "FilePath5", "FileDate5" }, };

	// This is the method that adds the row
	// receives variable:fileToAddInfoTable from class:SearchItFileIO method:getPath
	public static void addFileListener(String[] fileToAddInfoTable) {

		TableModel tableModelVar = indexTable.getModel();
		DefaultTableModel addRowObject = (DefaultTableModel) tableModelVar;
		addRowObject.addRow(fileToAddInfoTable);

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

	// method to create table
	public static Component createTable() {

		// Column Names
		String[] columns = new String[] { "File Name", "File Path", "Date Modified" };

		// Change column String to Object to comply with DefaultTableModel parameters
		Object[] columnObject = columns;

		Object[][] row = tableDataGatherer(fileInfo);

		// table creating code
		DefaultTableModel tableModel = new DefaultTableModel(row, columnObject);
		indexTable = new JTable(tableModel);

		// Table Sizing and table variable return to SearchItMaintenance Class
		indexTable.setPreferredScrollableViewportSize(indexTable.getPreferredSize());
		return indexTable;

	}
}
