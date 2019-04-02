/*
 * Class dedicated to table functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * -- Added remove function for Search.txt file.
 * 
 * 
 * Current Issues are displayed below:
 * 
 * Resolved Issues:
 * 
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.main;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SearchItTables {

	// Table
	static JTable indexTable;

	public static String[][] fileInfo = {};

	// Adds row to table
	public static void addFileListener(String[] fileToAddInfoTable) {

		TableModel tableModelVar = indexTable.getModel();
		DefaultTableModel addRowObject = (DefaultTableModel) tableModelVar;
		addRowObject.addRow(fileToAddInfoTable);
	}

	/*
	 * REMOVE FILE SECTION -- Basic framework
	 * 
	 * Checks row in table to specify deletion of file
	 */

	public static void removeFileIndex(int fileToAddInfoTable)
			throws FileNotFoundException {

		TableModel tableModelDetach = indexTable.getModel();
		DefaultTableModel removeRowObject = (DefaultTableModel) tableModelDetach;

		int selectedRowIndex = indexTable.getSelectedRow();

		if (indexTable.getSelectionModel().isSelectionEmpty()) {

		} else {

			removeRowObject.removeRow(selectedRowIndex);

			try (FileWriter writer = new FileWriter("Index.txt", true);
					BufferedWriter buffWrite = new BufferedWriter(writer);
					PrintWriter write = new PrintWriter("Index.txt");) {

				for (int gr = 0; gr < indexTable.getRowCount(); gr++) {

					for (int gc = 0; gc < indexTable.getColumnCount(); gc++) {

						buffWrite.write(indexTable.getModel()
								.getValueAt(gr, gc) + ",");
					}

					buffWrite.write("\n");
				}
			}

			catch (Exception ex) {
				ex.printStackTrace();
			}

			// Remove for Search.txt
			try (FileWriter writer = new FileWriter("Search.txt", true);
					BufferedWriter buffWrite = new BufferedWriter(writer);
					PrintWriter write = new PrintWriter("Search.txt");) {

				for (int gr = 0; gr < indexTable.getRowCount(); gr++) {

					for (int gc = 0; gc < indexTable.getColumnCount(); gc++) {
						if (gc == 0) {
							buffWrite.write(indexTable.getModel().getValueAt(
									gr, gc)
									+ "");
						} else {

						}
					}

					buffWrite.write("\n");
				}
			}

			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// Gets Table Data
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
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.setValueAt(i, i, 0);
		}

		String read = ",";

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
		indexTable.setPreferredScrollableViewportSize(indexTable
				.getPreferredSize());

		return indexTable;

	}

	private static BufferedReader getFileReader() throws FileNotFoundException {

		BufferedReader reader = new BufferedReader(new FileReader("Index.txt"));

		return reader;
	}
}
