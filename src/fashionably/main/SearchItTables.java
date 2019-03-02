/*
 * Class dedicated to table functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for table functionality
 * --TBA
 * --added compatability between getPath and SearchItTables classes.
 * --made the table be more dynamic
 * --added method stub for the addFileListener method 
 * which will work with the file path variable in the future. 
 * 
 * 
 * 
 * 
 * Current Issues are displayed below:
 * --Data in rows on columns are not setting from the FileChooser* *(Class: SearchItFileIO)
 * --data1 + data2 both are set to null for the sake of error removal
 * --TBA
 * --trying to get the Path part if the columns to work .
 * --what is the line "public static final String tableModel = null;"
 * used for??
 * --Method addFileListener is commented out until the dynamic table is working
 * 
 * 
 * Resolved Issues:
 * --Table has an initialized Table Model* ([Default]) *(tableModel)
 * --Data of rows is now an initialized variable* ([data1, data2]) *(null)
 * --TBA
 * 
 */

/*
 * May Need Later to import data into fields in JTable
 * 		
 * SearchItTables.createTable().getColumnModel().getColumn(columns).setCellEditor((TableCellEditor)
 *	new Indexing());
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.main;

import java.awt.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchItTables {
	
	//verify what this is needed for
	public static final String tableModel = null;

	/*
	// The String variable for addedFileInfo needs to be changed to String[]
	// whenever we have the other 2 methods for file information.
	public static String addedFileInfo;
	
	REMEMBER TO UNCOMMENT THE RETURN VARIABLE AT THE BOTTOM OF "SearchtFileIO" CLASS

	// The String parameter for addFileListener needs to be changed to String[]
	// whenever we have the other 2 methods for file information.
	 * 
	 * 
	public static String addFileListener(String pathTrial1) {

		return addedFileInfo;

	}
	*
	*/

	//dummy pre-made string to test table
	public static String[][] fileInfo = { { "FileName1", "FilePath1", "FileDate1" }, { "FileName2", "FilePath2", "FileDate2" }, { "FileName3", "FilePath3", "FileDate3" }, { "FileName4", "FilePath4", "FileDate4" }, };

	//Dynamic Table Code
	public static String[][] tableDataGatherer(String[][] fileInfo2){
		
		
		int secondArray = fileInfo2.length;
		String[][] rowInfo = new String[secondArray][3];
		
		for (int i = 0; i < fileInfo2.length; i++) {
			for (int j = 0; j < 3; j++) {
				rowInfo[i][j] = fileInfo2[i][j];
			}
		}
		
		return rowInfo;
	}

	
	public static Component createTable() {

		// Column Names
		String[] columns = new String[] { "File Name", "File Path", "Date Modified" };

		//Change column String to Object to comply with DefaultTableModel parameters
		Object[] columnObject = columns;
		
		Object[][] row = tableDataGatherer(fileInfo);

		//table creating code
		DefaultTableModel tableModel = new DefaultTableModel(row, columnObject);
		JTable indexTable = new JTable(tableModel);

		// SearchItTables.createTable().getColumnModel().getColumn(columns).setCellEditor((TableCellEditor)
		// new Indexing());


		// Table Sizing and table variable return to SearchItMaintenance Class
		indexTable.setPreferredScrollableViewportSize(indexTable.getPreferredSize());
		return indexTable;

	}
}
