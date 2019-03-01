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
 * Current Issues are displayed below:
 * --Data in rows on columns are not setting from the FileChooser* *(Class: SearchItFileIO)
 * --data1 + data2 both are set to null for the sake of error removal
 * --TBA
 * --trying to get the Path part if the columns to work .
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

	public static final String tableModel = null;

	// The String variable for addedFileInfo needs to be changed to String[]
	// whenever we have the other 2 methods for file information.
	public static String addedFileInfo;

	// The String parameter for addFileListener needs to be changed to String[]
	// whenever we have the other 2 methods for file information.
	public static String addFileListener(String pathTrial1) {

		return addedFileInfo;

	}

	public static String[][] giveTableValue() {

		String[][] fileInfo = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, };

		return fileInfo;
	}

	public static Component createTable() {

		// Column Names

		String[] columns = new String[] { "File Name", "File Path", "Date Modified" };

		Object[] columnObject = columns;

		Object[][] row = giveTableValue();

		DefaultTableModel tableModel = new DefaultTableModel(row, columnObject);

		JTable indexTable = new JTable(tableModel);

		// SearchItTables.createTable().getColumnModel().getColumn(columns).setCellEditor((TableCellEditor)
		// new Indexing());

		// Creating Table

		// Table Data
		// Object[][] row = new Object[][] { { data1, data2 } };
		/*
		 * String data1 = null; //SearchItFileIO.getPath(); !!!!MIGHT ADD LATER String
		 * data2 = null;
		 * 
		 * String[] item = { data1, data2 }; //tableModel.addRow(item);
		 * 
		 */

		// Table Sizing
		indexTable.setPreferredScrollableViewportSize(indexTable.getPreferredSize());
		return indexTable;

	}
}
