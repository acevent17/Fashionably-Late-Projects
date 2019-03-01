/*
 * Class dedicated to Frame Functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for Frame functionality
 * 
 * 
 * Current Issues are displayed below:
 * --N/A
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

//Importing classes from main package
import fashionably.main.SearchItAbout;
import fashionably.main.SearchItMaintenance;


public class SearchItFramework {

	public static void createSearchEngine() {

		// Creates Window
		final JFrame frame = new JFrame("Search Engine");

		// Set size and location of frame
		frame.setSize(750, 550);
		frame.setLocation(100, 150);
		frame.setLocationRelativeTo(null);

		// Close on exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sets labels and sizes
		JLabel titleLabel = new JLabel("Search Engine");
		titleLabel.setBounds(280, 10, 250, 50);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
		JTextField searchField = new JTextField();

		// Set size of the text box
		searchField.setBounds(247, 100, 250, 30);

		// Border
		/*
		 * Added a border, undecided about its looks. Change color if wanted or
		 * remove altogether.
		 * 
		 * 
		 * frame.getRootPane().setBorder( BorderFactory.createMatteBorder(3, 3,
		 * 3, 3, Color.BLACK));
		 */

		// Buttons
		JButton buttonSearch = new JButton("Search");
		buttonSearch.setBounds(323, 160, 100, 30);
		buttonSearch.setMnemonic(KeyEvent.VK_S);

		// Radio Buttons
		JRadioButton searchAll = new JRadioButton("Search All Phrases");
		searchAll.setMnemonic(KeyEvent.VK_A);

		JRadioButton searchExact = new JRadioButton("Search Exact Phrases");
		searchExact.setMnemonic(KeyEvent.VK_X);

		// Positioning
		searchAll.setBounds(230, 215, 145, 30);
		searchAll.setBackground(Color.cyan);
		searchExact.setBounds(380, 215, 155, 30);
		searchExact.setBackground(Color.cyan);

		// Radio Button Functionality
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(searchAll);
		radioButtons.add(searchExact);

		// Set Background Color
		frame.getContentPane().setBackground(Color.cyan);

		// MenuBar additions
		JMenuBar menubar = new JMenuBar();

		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);

		JMenu menuEdit = new JMenu("Edit");
		menuEdit.setMnemonic(KeyEvent.VK_E);

		JMenu menuMaintenance = new JMenu("Maintenance");
		menuMaintenance.setMnemonic(KeyEvent.VK_M);

		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);

		JMenuItem subMaintenanceMenu = new JMenuItem("Maintenance Panel");
		subMaintenanceMenu.setMnemonic(KeyEvent.VK_M);

		JMenuItem subAboutPage = new JMenuItem("About Page");
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
		

		// Creates maintenance form -Peter Quach's Creation
		subMaintenanceMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchItMaintenance.createSubMaintenance();
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
