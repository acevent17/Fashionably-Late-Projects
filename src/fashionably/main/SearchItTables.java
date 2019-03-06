/*
 * Class dedicated to table functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for table functionality
 * --added compatibility between getPath and SearchItTables classes.
 * --made the table be more dynamic
 * --completed compatibility between "class:SearchItFileIO method:getPath" and "class:SearchItTables method:addFileListener"
 * --
 * 
 * 
 * 
 * 
 * Current Issues are displayed below:
 * --what is the line "public static final String tableModel = null;"
 * used for??
 *  
 * -- Currently I am using String[] and Object[], however, Mr. Pollock recommends the use of List instead,
 *    this should be changed soon. // This is probably not necessary, we can keep working on the project and see.
 * 
 * -- Currently the file information that is added to the table is not being saved
 *    so once the table window is closed the information is lost. 
 *    future implementations should make this information permanent. 
 * 
 * 
 * 
 * 
 * Resolved Issues:
 * -- Table has an initialized Table Model* ([Default]) *(tableModel)
 * -- Data of rows is now an initialized variable* ([data1, data2]) *(null)
 * -- Data in rows on columns are not setting from the FileChooser* *(Class: SearchItFileIO)
 * -- All the row information to work and be added to the table
 * -- Removed place holders: filename, pathname, and date.
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
	// receives variable:fileToAddInfoTable from class:SearchItFileIO method:getPath
	public static void addFileListener(String[] fileToAddInfoTable) {

		TableModel tableModelVar = indexTable.getModel();
		DefaultTableModel addRowObject = (DefaultTableModel) tableModelVar;
		addRowObject.addRow(fileToAddInfoTable);
		
		//boolean variable and if statement that will activate if the user
		//adds or deletes any files from the database
		boolean secondIndexBoolean = IndexChecker.IndexChangesCheck();
		if(secondIndexBoolean = true) {
			//update index file
		}
		else {
			//do nothing?
		}

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
		
		     String read = ";";

        try
        {
            BufferedReader reader = getFileReader();

            //  First line will contain the column names

            String line = reader.readLine();
            tableModel.setColumnIdentifiers( line.split(read) );

            //  Remaining lines in the file will be the data
            
            
            
            while ((line = reader.readLine()) != null)
            {
                tableModel.addRow( line.split(read) );
            }

            reader.close();
        }
        catch(Exception e) { System.out.println(e); }
        
		// Table Sizing and table variable return to SearchItMaintenance Class
		indexTable.setPreferredScrollableViewportSize(indexTable.getPreferredSize());
		
		return indexTable;
		
	}
    
    private static BufferedReader getFileReader() throws FileNotFoundException
    {
        
        BufferedReader reader = new BufferedReader( new FileReader("JSON.txt") );

        return reader;
    }
	
}
