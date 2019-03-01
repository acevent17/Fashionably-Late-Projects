/*
 * Class dedicated to table functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for table functionality
 * --TBA
 * 
 * 
 * Current Issues are displayed below:
 * --Data in rows on columns are not setting from the FileChooser* *(Class: SearchItFileIO)
 * --data1 + data2 both are set to null for the sake of error removal
 * --TBA
 * 
 * 
 * Resolved Issues:
 * --Table has an initialized Table Model* ([Default]) *(tableModel)
 * --Data of rows is now an initalized variable* ([data1, data2]) *(null)
 * --TBA
 * 
 */

/*
 * May Need Later to import data into fields in JTable
 */
// SearchItTables.createTable().getColumnModel().getColumn(columns).setCellEditor((TableCellEditor)
// new Indexing());


/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.main;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class SearchItTables {
	public static final String tableModel = null;

	public static Component createTable() {

		// Column Names
		String[] columns = new String[] { "File Name", "Status" };

		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

		// Creating Table
		JTable indexTable = new JTable(tableModel);

		// Table Data
		// Object[][] row = new Object[][] { { data1, data2 } };

		String data1 = null; //SearchItFileIO.getPath(); 
		String data2 = null;

		String[] item = { data1, data2 };
		tableModel.addRow(item);

		// Table Sizing
		indexTable.setPreferredScrollableViewportSize(indexTable
				.getPreferredSize());
		return indexTable;
		
		
		
		

	}
}
