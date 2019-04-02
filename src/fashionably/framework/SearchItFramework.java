/*
 * Class dedicated to Frame Functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for Frame functionality
 * --Changed menu item from "About Page" to "About"
 * --Created functionality for Search Button
 * --Added Search Any Phrase RadioButton
 * 
 * Current Issues are displayed below:
 * --Created method to get total line count of Index File. Not showing count
 * 
 * 
 * Resolved Issues:
 * --TBA
 * 
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.framework;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Scanner;

//Importing classes from main package
import fashionably.main.SearchItAbout;
import fashionably.main.SearchItMaintenance;

public class SearchItFramework {

	/*
	 * Global Variables
	 */

	// Frame
	static final JFrame frame = new JFrame("Search Engine");

	// Integer
	static int indexedFileTotal;

	// Text Field
	static JTextField searchField = new JTextField();

	// Text Area
	static JTextArea searchFieldArea = new JTextArea();

	// Label
	static JLabel titleLabel = new JLabel("Search Engine");
	static JLabel noFile = new JLabel("No File Found");

	// Button Group
	static ButtonGroup radioButtons = new ButtonGroup();

	// Button
	static JButton buttonSearch = new JButton("Search");

	// Radio Button
	// All(OR)
	static JRadioButton searchAll = new JRadioButton("Search OR Phrases");
	// Exact(PHRASE)
	static JRadioButton searchExact = new JRadioButton("Search Exact Phrases");
	// Any(AND)
	static JRadioButton searchAny = new JRadioButton("Search AND Phrase");

	// Menu Bar
	static JMenuBar menubar = new JMenuBar();

	// Menu Additions
	static JMenu menuFile = new JMenu("File");
	static JMenu menuEdit = new JMenu("Edit");
	static JMenu menuMaintenance = new JMenu("Maintenance");
	static JMenu menuHelp = new JMenu("Help");

	// Menu Items
	static JMenuItem subMaintenanceMenu = new JMenuItem("Maintenance Panel");
	static JMenuItem subAboutPage = new JMenuItem("About");

	// String Search Functionality
	static String anySearch;
	static String allSearch;
	static String exactSearch;

	/*
	 * Search Phrase Section Current Layout: searchPhrase() will search the
	 * phrase within the searchField will be assigned to variable and set to the
	 * current contents of the searchField. The radiobutton checkstates' will be
	 * checked to find out which phrase is being searched
	 */

	public static void searchPhrase() throws FileNotFoundException {

		/*
		 * Current situation with read file: Workflow: Scanner reads
		 * "Index.txt", the user entered string in the textfield, and the radio
		 * button checkstate (Currently only working with OR). The scanner
		 * outputs the file name (trimmed off pathname) based on if file is
		 * within "Index.txt".
		 * 
		 * Latest code when ran displays every line that has an existing
		 * character equal to the textfield entry. To Replicate: OPEN
		 * APPLICATION -> add new file -> OPEN INDEX.TXT -> add new line under
		 * line 1 as an integer "1" -> add new line as "apple" -> Run
		 * application -> Select "OR" radioButton -> type a single character
		 * that exists within the file or path (returns multiple entries of file
		 * search + No File Found(??)) -> type "1" (No File Found, due to
		 * parameters of search not accepting integers) -> type "apple" (No File
		 * Found)
		 */

		// Gets text within the searchField - Can be set to console output for
		// debugging
		String searchText = searchField.getText();
		// System.out.println(searchText);

		File index = new File("Index.txt");

		// Data Validation
		if (searchAll.isSelected() == false
				&& searchExact.isSelected() == false
				&& searchAny.isSelected() == false) {
			System.out.println("Select a Search Phrase");
			searchFieldArea.setText("Select a Search Phrase");
		}

		// Creates scanner to read from file and textbox string
		Scanner indexScanner = new Scanner(index);
		String phrase = indexScanner.findInLine("[A-Za-z].*[A-Za-z]");

		// Creates Switches to handle search phrases
		int searchSwitchOR = 1;
		int searchSwitchAND = 1;
		int searchSwitchPHRASE = 1;

		/*
		 * Handles PHRASE search phrase: [EXPLAIN WORKFLOW FOR "PHRASE" SEARCH]
		 */
		if (searchExact.isSelected() == true) {
			switch (searchSwitchPHRASE) {

			// Data Validation
			case 1:
				if (searchText.isEmpty()) {
					System.out.println("Enter a File Name");
					searchFieldArea.setText("Enter a File Name");
					break;
				}
				// Search Functionality
			case 2:
				/*
				 * scanner goes here
				 */

				// File Validation
			case 3:
				/*
				 * File not found goes here
				 */
			}
		}

		/*
		 * Handles AND search phrase: [EXPLAIN WORKFLOW FOR "AND" SEARCH]
		 */
		if (searchAny.isSelected() == true) {
			switch (searchSwitchAND) {

			// Data Validation
			case 1:
				if (searchText.isEmpty()) {
					System.out.println("Enter a File Name");
					searchFieldArea.setText("Enter a File Name");
					break;
				}
				// Search Functionality
			case 2:
				/*
				 * Scanner goes here
				 */

				// File Validation
			case 3:
				/*
				 * File not found goes here
				 */
			}
		}

		/*
		 * Handles OR search phrase: [EXPLAIN WORKFLOW FOR "OR" SEARCH]
		 */
		if (searchAll.isSelected() == true) {
			switch (searchSwitchOR) {

			// Data Validation
			case 1:
				if (searchText.isEmpty()) {
					System.out.println("Enter a File Name");
					searchFieldArea.setText("Enter a File Name");
					break;
				}

				// Search Functionality
			case 2:
				if (searchAll.isSelected() == true) {
					Scanner lineScanner = new Scanner(new File("Index.txt"));
					int lineCount = 0;
					while (lineScanner.hasNextLine()) {
						String lineToRead = lineScanner.nextLine();
						if ((lineToRead.contains(searchText))
								&& (phrase.length() > 0)) {
							System.out.printf("%d: %s %n", lineCount,
									lineToRead);
							lineCount++;
						}

					}

				}

			case 3:
				/*
				 * No File Found needs to be implimented(???)
				 */
			}

		}

	}

	public static void getLines() {
		/*
		 * !!---DELETE IF NOT USED BEFORE FINAL TURN-IN---!! Get the total lines
		 * from the "Index.txt" file then displays it on the "indexedFileTotal"
		 * label Not yet working fully. **See under elements added (Line 181).
		 * Method is called in FashionablySearchIt(Line 52). && SearchItFileIO
		 * (Line 115)
		 */
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"Index.txt"));
			while (reader.readLine() != null)
				indexedFileTotal++;
			reader.close();
		} catch (Exception e) {
			System.out.println("No Files Indexed");
		}

	}

	public static void createSearchEngine() {

		// Set size and location of frame
		frame.setSize(750, 550);
		frame.setLocation(100, 150);
		frame.setLocationRelativeTo(null);

		// Set Background Color
		frame.getContentPane().setBackground(Color.cyan);

		// Close on exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sets labels and sizes
		titleLabel.setBounds(280, 10, 250, 50);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
		noFile.setBounds(10, 30, 250, 50);

		// Set size of the text box
		searchField.setBounds(247, 80, 250, 30);

		// Set size of the text Area
		searchFieldArea.setBounds(10, 230, 715, 250);

		// Buttons
		buttonSearch.setBounds(323, 130, 100, 30);
		buttonSearch.setMnemonic(KeyEvent.VK_S);

		// Radio Button Hotkeys
		searchAll.setMnemonic(KeyEvent.VK_A);
		searchExact.setMnemonic(KeyEvent.VK_X);
		searchAny.setMnemonic(KeyEvent.VK_N);

		// Positioning
		searchAll.setBounds(301, 180, 145, 30);
		searchAll.setBackground(Color.cyan);
		searchExact.setBounds(455, 180, 155, 30);
		searchExact.setBackground(Color.cyan);
		searchAny.setBounds(145, 180, 155, 30);
		searchAny.setBackground(Color.cyan);

		// Radio Button Group Additions
		radioButtons.add(searchAll);
		radioButtons.add(searchExact);
		radioButtons.add(searchAny);

		// MenuBar additions
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuEdit.setMnemonic(KeyEvent.VK_E);
		menuMaintenance.setMnemonic(KeyEvent.VK_M);
		menuHelp.setMnemonic(KeyEvent.VK_H);

		subMaintenanceMenu.setMnemonic(KeyEvent.VK_M);
		subAboutPage.setMnemonic(KeyEvent.VK_A);

		// SubMenu additions
		menuMaintenance.add(subMaintenanceMenu);
		menuHelp.add(subAboutPage);

		// Elements added
		frame.add(titleLabel);
		frame.add(searchField);
		frame.add(searchFieldArea);
		frame.add(buttonSearch);
		frame.add(searchAll);
		frame.add(searchExact);
		frame.add(searchAny);
		frame.add(noFile);

		frame.setJMenuBar(menubar);
		frame.setLayout(null);
		frame.setVisible(true);
		noFile.setVisible(false);

		// Adding MenuBar Items
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuMaintenance);
		menubar.add(menuHelp);

		// Tool Tips
		buttonSearch.setToolTipText("Search Function");
		searchField.setToolTipText("Enter Text ");
		searchAll.setToolTipText("Search through everything");
		searchExact.setToolTipText("Search for exact word or phrase");
		subMaintenanceMenu.setToolTipText("Opens Maintenance page");
		subAboutPage.setToolTipText("Shows information about this project");

		// Creates Maintenance Form
		subMaintenanceMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchItMaintenance.createSubMaintenance();
			}
		});

		// Handles Search Button Functionality
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchPhrase();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// Creates new frame for About page
		subAboutPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchItAbout.createSubAbout();
			}
		});
	}
}
