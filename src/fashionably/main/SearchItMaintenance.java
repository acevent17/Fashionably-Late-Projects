/*
 * Class dedicated to Maintenance Frame Functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for Maintenance functionality
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
package fashionably.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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

	public static void createSubMaintenance() {

		// Sub Maintenance Frame
		final JFrame subMaintenanceFrame = new JFrame();

		subMaintenanceFrame.setVisible(true);
		subMaintenanceFrame.setSize(700, 500);
		subMaintenanceFrame.setLocation(1000, 350);
		subMaintenanceFrame.setTitle("Search Engine Maintenance");
		subMaintenanceFrame.setLocationRelativeTo(null);
		subMaintenanceFrame.getContentPane().setBackground(Color.cyan);

		// Header and other labels
		JPanel maintenancePanel = new JPanel();
		maintenancePanel.add(new JLabel("Search Engine - Index Maintenance"));
		subMaintenanceFrame.add(maintenancePanel, BorderLayout.NORTH);

		JLabel labelFileNumber = new JLabel("Number of files indexed: 0");
		labelFileNumber.setBounds(180, 395, 160, 30);
		JLabel labelVersion = new JLabel("Search Engine Version 1.1");
		labelVersion.setBounds(420, 395, 160, 30);

		// Menu Bar
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);

		JMenu menuEdit = new JMenu("Edit");
		menuEdit.setMnemonic(KeyEvent.VK_E);

		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);

		subMaintenanceFrame.setJMenuBar(menubar);

		// Menu Items
		final JMenuItem subAddFile = new JMenuItem("Add File");
		JMenuItem subRebuild = new JMenuItem("Rebuild");
		JMenuItem subRemoveFile = new JMenuItem("Remove File");
		JMenuItem subResetWindow = new JMenuItem("Reset Window");
		JMenuItem subAboutPage = new JMenuItem("About Page");

		// Elements added
		subMaintenanceFrame.add(labelFileNumber);
		subMaintenanceFrame.add(labelVersion);

		// Menu-bar additions
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuHelp);

		// sub Menu-bar additions
		menuFile.add(subAddFile);
		menuEdit.add(subRebuild);
		menuEdit.add(subRemoveFile);
		menuEdit.add(subResetWindow);
		menuHelp.add(subAboutPage);

		// sub Menu-bar Hot Keys
		subAddFile.setMnemonic(KeyEvent.VK_A);
		subRebuild.setMnemonic(KeyEvent.VK_B);
		subRemoveFile.setMnemonic(KeyEvent.VK_R);
		subResetWindow.setMnemonic(KeyEvent.VK_W);
		subAboutPage.setMnemonic(KeyEvent.VK_A);

		// Tool Tips
		subAddFile.setToolTipText("Adds file to table");
		subRebuild.setToolTipText("Rebuilds table?");
		subRemoveFile.setToolTipText("Removes file from table");
		subResetWindow.setToolTipText("Resets window to original state");
		subAboutPage.setToolTipText("Shows information about this project");

		// Table Creation
		SearchItTables.createTable();

		// Adding Table to SubFrame
		subMaintenanceFrame.add(new JScrollPane(SearchItTables.createTable()));
		subMaintenanceFrame.setVisible(true);

		subAddFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchItFileIO.fileHandler();
			}
		});
	}

}
