/*
 * Class dedicated to Frame Functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 *  --Search buttons all work now
 * 
 * 
 * Current Issues are displayed below:
 * 
 * 
 * 
 * Resolved Issues:
 * --N/A
 * 
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.framework;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

//Importing classes from main package
import fashionably.main.SearchItAbout;
import fashionably.main.SearchItMaintenance;

public class SearchItFramework {

	// Global Variables

	// All(OR)
	static JRadioButton searchAll = new JRadioButton("Search OR Phrases");
	// Exact(PHRASE)
	static JRadioButton searchExact = new JRadioButton("Search Exact Phrases");
	// Any(AND)
	static JRadioButton searchAny = new JRadioButton("Search AND Phrase");

	// Integer
	static int indexedFileTotal;

	// Text Field
	static JTextField searchField = new JTextField();

	// Text Area
	static JTextArea searchFieldArea = new JTextArea();

	/*
	 * Search Phrase Section Current Layout: searchPhrase() will search the
	 * phrase within the searchField will be assigned to variable and set to the
	 * current contents of the searchField. The radiobutton checkstates' will be
	 * checked to find out which phrase is being searched
	 */
	public static void searchPhrase() throws FileNotFoundException {

		// Gets text within the searchField - Can be set to console output for
		String searchText = searchField.getText();

		// Debugging
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
		 * Handles PHRASE search phrase: searchExact - Searches for an EXACT
		 * text string from the Search.txt file
		 */
		if (searchExact.isSelected() == true) {
			switch (searchSwitchPHRASE) {

			// Data Validation
			case 1:
				if (searchText.isEmpty()) {
					searchFieldArea.setText("Enter a File Name");
					break;
				}
				// Search Functionality
			case 2:
				searchFieldArea.setText("");

				Scanner lineScanner = new Scanner(new File("Search.txt"));

				while (lineScanner.hasNextLine()) {
					String lineToRead = lineScanner.nextLine();
					if ((lineToRead.equals(searchText))
							&& (phrase.length() > 0)) {
						searchFieldArea.append(String.format("%s %n",
								lineToRead));
					}
				}
			}
		}

		/*
		 * Handles AND search phrase: searchAny - Searches through the
		 * Search.txt file for text not entered into the text box.
		 */
		if (searchAny.isSelected() == true) {
			switch (searchSwitchAND) {

			// Data Validation
			case 1:
				if (searchText.isEmpty()) {
					searchFieldArea.setText("Enter a File Name");
					break;
				}
				// Search Functionality
			case 2:
				searchFieldArea.setText("");

				Scanner lineScanner = new Scanner(new File("Search.txt"));

				while (lineScanner.hasNextLine()) {
					String lineToRead = lineScanner.nextLine();
					if ((!lineToRead.contains(searchText))
							&& (phrase.length() > 0)) {
						searchFieldArea.append(String.format("%s %n",
								lineToRead));
					}
				}
			}
		}

		/*
		 * Handles OR search phrase: [EXPLAIN WORKFLOW FOR "OR" SEARCH] Searches
		 * through the Search.txt file for all text entered.
		 */
		if (searchAll.isSelected() == true) {
			switch (searchSwitchOR) {

			// Data Validation
			case 1:
				if (searchText.isEmpty()) {
					searchFieldArea.setText("Enter a File Name");
					break;
				}

				// Search Functionality
			case 2:
				if (searchAll.isSelected() == true) {
					searchFieldArea.setText("");

					Scanner lineScanner = new Scanner(new File("Search.txt"));

					while (lineScanner.hasNext()) {
						String lineToRead = lineScanner.nextLine();

						if ((lineToRead.contains(searchText))
								&& (phrase.length() > 0)) {
							searchFieldArea.append(String.format("%s %n",
									lineToRead));
						}

					}

				}

			}

		}

	}

	public static void createSearchEngine() {
		// Frame
		final JFrame frame = new JFrame("Search Engine");

		// Label
		JLabel titleLabel = new JLabel("Search Engine");

		// Button Group
		ButtonGroup radioButtons = new ButtonGroup();

		// Button
		JButton buttonSearch = new JButton("Search");

		// Menu Bar
		JMenuBar menubar = new JMenuBar();

		// Menu Additions
		JMenu menuFile = new JMenu("File");
		JMenu menuEdit = new JMenu("Edit");
		JMenu menuMaintenance = new JMenu("Maintenance");
		JMenu menuHelp = new JMenu("Help");

		// Menu Items
		JMenuItem subMaintenanceMenu = new JMenuItem("Maintenance Panel");
		JMenuItem subAboutPage = new JMenuItem("About");

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

		// Set size of the text box
		searchField.setBounds(247, 80, 250, 30);

		// Set size of the text Area
		searchFieldArea.setBounds(10, 230, 715, 250);
		// Non-editable
		searchFieldArea.setEditable(false);
		// Wraps lines automatically
		searchFieldArea.setLineWrap(true);
		// Breaks lines
		searchFieldArea.setWrapStyleWord(true);

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

		frame.setJMenuBar(menubar);
		frame.setLayout(null);
		frame.setVisible(true);

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
