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
import java.io.FileReader;

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

	// Label
	static JLabel titleLabel = new JLabel("Search Engine");
	static JLabel indexedFiles = new JLabel("Number of Files Indexed: "
			+ indexedFileTotal);

	// Button Group
	static ButtonGroup radioButtons = new ButtonGroup();

	// Button
	static JButton buttonSearch = new JButton("Search");

	// Radio Button
	static JRadioButton searchAll = new JRadioButton("Search All Phrases");
	static JRadioButton searchExact = new JRadioButton("Search Exact Phrases");
	static JRadioButton searchAny = new JRadioButton("Search Any Phrase");

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
	static String searchText = searchField.getText();
	static String anySearch;
	static String allSearch;
	static String exactSearch = searchText;

	/*
	 * Search Phrase Section Current Layout: searchPhrase() will search the
	 * phrase within the searchField will be assigned to variable and set to the
	 * current contents of the searchField. The radiobutton checkstates' will be
	 * checked to find out which phrase is being searched
	 */
	public static void searchPhrase() {

		System.out.println(searchText);

	}

	public static void getLines() {
		/*
		 * Get the total lines from the "Index.txt" file then displays it on the
		 * "indexedFileTotal" label Not yet working fully. **See under elements
		 * added (Line 181). Method is called in FashionablySearchIt(Line 52).
		 * && SearchItFileIO (Line 115)
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

		indexedFiles.setBounds(10, 200, 200, 550);

		// Set size of the text box
		searchField.setBounds(247, 100, 250, 30);

		// Buttons
		buttonSearch.setBounds(323, 160, 100, 30);
		buttonSearch.setMnemonic(KeyEvent.VK_S);

		// Radio Button Hotkeys
		searchAll.setMnemonic(KeyEvent.VK_A);
		searchExact.setMnemonic(KeyEvent.VK_X);
		searchAny.setMnemonic(KeyEvent.VK_N);

		// Positioning
		searchAll.setBounds(301, 215, 145, 30);
		searchAll.setBackground(Color.cyan);
		searchExact.setBounds(455, 215, 155, 30);
		searchExact.setBackground(Color.cyan);
		searchAny.setBounds(145, 215, 155, 30);
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
		frame.add(buttonSearch);
		frame.add(searchAll);
		frame.add(searchExact);
		frame.add(searchAny);
		frame.add(indexedFiles);
		// frame.add(indexedFileTotal);
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
				searchPhrase();
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
