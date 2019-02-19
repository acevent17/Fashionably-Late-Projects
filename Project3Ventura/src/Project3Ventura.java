//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/* Changes:
 * Cleaned up code
 * Added a border (Optional)
 * Removed header label on Sub-Frame (*Add back if wanted)
 * Adjusted About Alignment
 * Added "TO BE REMOVED" tags
 * 
 * 
 * TO BE DONE:
 * 
 * 
 *--IF CODE DOES NOT LOAD, CHANGE BUILD COMPATABILITY TO JAVA 10. (Right-click Project -> Properties -> Java Build Path
 * -> (Libraries Tab) -> Double-click JRE Library -> Alternate JRE -> (Set your java version)
 */

public class Project3Ventura {

	private static void createSubAbout() {
		// Sub About Frame
		JFrame aboutSubFrame = new JFrame();
		aboutSubFrame.setVisible(true);
		aboutSubFrame.setSize(400, 250);
		aboutSubFrame.setLocation(150, 200);
		aboutSubFrame.setTitle("About Page");
		aboutSubFrame.setLocationRelativeTo(null);

		// Labels
		JLabel headerLabel = new JLabel("About Search Engine");
		headerLabel.setBounds(100, 5, 450, 50);
		headerLabel.setFont(new Font("Serif", Font.BOLD, 20));

		JLabel versionLabel = new JLabel("Version 1.0.0-30");
		versionLabel.setBounds(136, 25, 450, 50);
		versionLabel.setFont(new Font("Serif", Font.PLAIN, 15));

		JLabel byLabel = new JLabel("By:");
		byLabel.setBounds(180, 45, 450, 50);
		byLabel.setFont(new Font("Serif", Font.BOLD, 16));

		JLabel pqLabel = new JLabel("Peter Quach");
		pqLabel.setBounds(154, 65, 450, 50);
		pqLabel.setFont(new Font("Serif", Font.PLAIN, 16));

		JLabel mtLabel = new JLabel("Michael Tarallo");
		mtLabel.setBounds(147, 85, 450, 50);
		mtLabel.setFont(new Font("Serif", Font.PLAIN, 16));

		JLabel jvLabel = new JLabel("Joshua Ventura");
		jvLabel.setBounds(147, 105, 450, 50);
		jvLabel.setFont(new Font("Serif", Font.PLAIN, 16));

		JLabel acLabel = new JLabel("Andres Cardenas");
		acLabel.setBounds(142, 125, 450, 50);
		acLabel.setFont(new Font("Serif", Font.PLAIN, 16));

		JLabel classLabel = new JLabel("Mr. Pollock Java II COP-2805C");
		classLabel.setBounds(116, 145, 450, 50);
		classLabel.setFont(new Font("Serif", Font.PLAIN, 12));

		// Elements added to About frame
		aboutSubFrame.add(headerLabel);
		aboutSubFrame.add(versionLabel);
		aboutSubFrame.add(byLabel);
		aboutSubFrame.add(pqLabel);
		aboutSubFrame.add(mtLabel);
		aboutSubFrame.add(jvLabel);
		aboutSubFrame.add(acLabel);
		aboutSubFrame.add(classLabel);

		aboutSubFrame.setLayout(null);
	}

	private static void createSubMaintenance() {
		// Sub Maintenance Frame
		JFrame subMaintenanceFrame = new JFrame();
		subMaintenanceFrame.setVisible(true);
		subMaintenanceFrame.setSize(600, 400);
		subMaintenanceFrame.setLocation(100, 150);
		subMaintenanceFrame.setTitle("Search Engine Maintenance");
		subMaintenanceFrame.setLocationRelativeTo(null);

		subMaintenanceFrame.getContentPane().setBackground(Color.cyan);

		// Header and other labels
		/*
		 * --TO BE REMOVED AT THE START OF NEXT PROJECT UNLESS USED--
		 * 
		 * SubHeader = new JLabel("Search Engine - Index Maintenance");
		 * SubHeader.setBounds(100, 5, 450, 50); SubHeader.setFont(new
		 * Font("Serif", Font.BOLD, 26));
		 */

		JLabel labelFileNumber = new JLabel("Number of files indexed: 0");
		labelFileNumber.setBounds(180, 340, 160, 30);
		JLabel labelVersion = new JLabel("Search Engine Version 1.1");
		labelVersion.setBounds(420, 340, 160, 30);

		// All the buttons on the bottom of the Maintenance Page
		/*
		 * --TO BE REMOVED AT THE START OF NEXT PROJECT UNLESS USED--
		 * 
		 * JButton buttonAddFile = new JButton("Add File...");
		 * buttonAddFile.setBounds(20, 280, 95, 30);
		 * 
		 * JButton buttonRebuild = new JButton("Rebuild Out-of-date");
		 * buttonRebuild.setBounds(180, 300, 160, 30);
		 * 
		 * JButton buttonRemoveFile = new JButton("Remove Selected Files");
		 * buttonRemoveFile.setBounds(400, 300, 180, 30);
		 * 
		 * JButton buttonResetWindow = new JButton("Reset Windows");
		 * buttonResetWindow.setBounds(10, 325, 130, 30);
		 */

		// Menu Bar
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuEdit = new JMenu("Edit");
		JMenu menuAbout = new JMenu("About");

		subMaintenanceFrame.setJMenuBar(menubar);

		JMenuItem subAddFile = new JMenuItem("Add File");
		menuFile.add(subAddFile);
		JMenuItem subRebuild = new JMenuItem("Rebuild");
		menuEdit.add(subRebuild);
		JMenuItem subRemoveFile = new JMenuItem("Remove File");
		menuEdit.add(subRemoveFile);
		JMenuItem subResetWindow = new JMenuItem("Reset Window");
		menuEdit.add(subResetWindow);

		// Elements added

		subMaintenanceFrame.add(labelFileNumber);
		subMaintenanceFrame.add(labelVersion);
		/*
		 * --TO BE REMOVED AT THE START OF NEXT PROJECT UNLESS USED--
		 * 
		 * subMaintenanceFrame.add(SubHeader);
		 * subMaintenanceFrame.add(buttonAddFile);
		 * subMaintenanceFrame.add(buttonRebuild);
		 * subMaintenanceFrame.add(buttonRemoveFile);
		 * subMaintenanceFrame.add(buttonResetWindow);
		 */

		// Menu-bar additions
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuAbout);

		/*
		 * Table Info --Below is the functionality and implementation for the
		 * Indexing Table
		 */

		// Column Names
		String[] columns = new String[] { "File Name", "Status" };

		// Table Data
		Object[][] data = new Object[][] { { "Test", "Active" },

		};

		// Creating Table
		JTable indexTable = new JTable(data, columns);

		// Adding Table to SubFrame
		subMaintenanceFrame.add(new JScrollPane(indexTable));
		subMaintenanceFrame.setVisible(true);

		// Table Sizing
		indexTable.setPreferredScrollableViewportSize(indexTable
				.getPreferredSize());

		// Frame Layout
		subMaintenanceFrame.setLayout(null);

	}

	private static void createWindow() {

		// Creates Window
		final JFrame frame = new JFrame("Search Engine");

		// Set size and location of frame
		frame.setSize(600, 400);
		frame.setLocation(100, 150);
		frame.setLocationRelativeTo(null);

		// Close on exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sets labels and sizes
		JLabel titleLabel = new JLabel("Search Engine");
		titleLabel.setBounds(198, 10, 250, 50);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
		JTextField searchField = new JTextField();

		// Border
		/*
		 * Added a border, undecided about its looks. Change color if wanted or
		 * remove altogether.
		 */
		frame.getRootPane().setBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));

		// Set size of the text box
		searchField.setBounds(190, 100, 200, 30);

		// Buttons
		JButton buttonSearch = new JButton("Search");
		buttonSearch.setBounds(242, 150, 100, 30);

		// Radio Buttons
		JRadioButton searchAll = new JRadioButton("Search All Phrases");
		JRadioButton searchExact = new JRadioButton("Search Exact Phrases");

		// Positioning
		searchAll.setBounds(150, 190, 145, 30);
		searchAll.setBackground(Color.cyan);
		searchExact.setBounds(300, 190, 155, 30);
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
		JMenu menuEdit = new JMenu("Edit");
		JMenu menuMaintenance = new JMenu("Maintenance");
		JMenu menuHelp = new JMenu("Help");
		JMenuItem subMaintenanceMenu = new JMenuItem("Maintenance Panel");
		JMenuItem subAboutPage = new JMenuItem("About Page");

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

		// Creates maintenance form -Peter Quach's Creation
		subMaintenanceMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createSubMaintenance();
			}
		});

		// Creates new frame for About page
		subAboutPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createSubAbout();
			}
		});

	}

	// Main Class
	public static void main(String[] args) {
		createWindow();

	}

}
