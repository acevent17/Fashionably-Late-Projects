/*
 * Class dedicated to Maintenance Frame Functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --N/A
 * 
 * Current Issues are displayed below:
 * --N/A
 * 
 * 
 * Resolved Issues:
 * --N/A
 * 
 */

/*
 * Imports used in relation to class name and functionality respectively
 */
package fashionably.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//Importing classes from main package
import fashionably.main.SearchItTables;

public class SearchItMaintenance {

	public static final Component subMaintenanceFrame = null;

	// Sub Maintenance Frame
	public static void createSubMaintenance() {

		// Frame
		final JFrame subMaintenanceFrame = new JFrame();
		JPanel maintenancePanel = new JPanel();
		final JMenuItem subAddFile = new JMenuItem("Add File");

		// Menu Bar
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuEdit = new JMenu("Edit");
		JMenu menuHelp = new JMenu("Help");

		// Menu Item
		JMenuItem subRebuild = new JMenuItem("Rebuild");
		JMenuItem subRemoveFile = new JMenuItem("Remove File");
		JMenuItem subModified = new JMenuItem("Check if Modifed");
		JMenuItem subResetWindow = new JMenuItem("Reset Window");
		JMenuItem subAboutPage = new JMenuItem("About");

		// Frame Positioning
		subMaintenanceFrame.setVisible(true);
		subMaintenanceFrame.setSize(700, 500);
		subMaintenanceFrame.setLocation(1000, 350);
		subMaintenanceFrame.setTitle("Search Engine Maintenance");
		subMaintenanceFrame.setLocationRelativeTo(null);
		subMaintenanceFrame.getContentPane().setBackground(Color.cyan);

		// Header and other labels
		maintenancePanel.add(new JLabel("Search Engine - Index Maintenance"));
		subMaintenanceFrame.add(maintenancePanel, BorderLayout.NORTH);

		JLabel labelFileNumber = new JLabel();
		JLabel labelVersion = new JLabel("Search Engine Version 1.2");

		// File Number
		labelFileNumber.setBounds(180, 395, 160, 30);

		// Version
		labelVersion.setBounds(420, 395, 160, 30);

		// File
		menuFile.setMnemonic(KeyEvent.VK_F);

		// Edit
		menuEdit.setMnemonic(KeyEvent.VK_E);

		// Help
		menuHelp.setMnemonic(KeyEvent.VK_H);

		// Adding the Menu Bar
		subMaintenanceFrame.setJMenuBar(menubar);

		// Elements added
		subMaintenanceFrame.add(labelFileNumber);
		subMaintenanceFrame.add(labelVersion);

		// Menu-bar additions
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuHelp);

		// Sub Menu-bar additions
		menuFile.add(subAddFile);
		menuEdit.add(subRebuild);
		menuEdit.add(subRemoveFile);
		menuEdit.add(subModified);
		menuEdit.add(subResetWindow);
		menuHelp.add(subAboutPage);

		// Sub Menu-bar Hot Keys
		subAddFile.setMnemonic(KeyEvent.VK_A);
		subRebuild.setMnemonic(KeyEvent.VK_B);
		subRemoveFile.setMnemonic(KeyEvent.VK_R);
		subResetWindow.setMnemonic(KeyEvent.VK_W);
		subAboutPage.setMnemonic(KeyEvent.VK_A);

		// Tool Tips
		subAddFile.setToolTipText("Adds file to table");
		subRebuild.setToolTipText("Rebuilds table");
		subRemoveFile.setToolTipText("Removes file from table");
		subResetWindow.setToolTipText("Resets window to original state");
		subAboutPage.setToolTipText("Shows information about this project");

		// Table Creation
		SearchItTables.createTable();

		// Adding Table to SubFrame
		subMaintenanceFrame.add(new JScrollPane(SearchItTables.createTable()));
		subMaintenanceFrame.setVisible(true);
		subMaintenanceFrame.validate();

		// Remove File Handler. See(*SearchItTables.RemoveFileIndex());)
		subRemoveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SearchItTables.removeFileIndex(0);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Creates and shows the About page
		subAboutPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchItAbout.createSubAbout();
			}
		});

		// Implements file handlers needed to add files to table and index
		subAddFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchItFileIO.fileHandler();
			}
		});

		// Resets windows to center of screen
		subResetWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subMaintenanceFrame.setLocationRelativeTo(null);
			}
		});
	}

}
