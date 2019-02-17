//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/* Changes:
 * Cleaned up code, fixed the ability to customize color + sub menu buttons.
 * TO BE DONE:
 * --Font needs to be set for titleLabel.
 * --Radio Buttons need to be added.
 * --2nd Frame needs to be completed and designed
 * --IF CODE DOES NOT LOAD, CHANGE BUILD COMPATABILITY TO JAVA 10. (Right-click Project -> Properties -> Java Build Path
 * -> (Libraries Tab) -> Double-click JRE Library -> Alternate JRE -> (Set your java version)
 */


public class Project3Ventura {	
	private static void createWindow() {

		// Creates Window
		final JFrame frame = new JFrame("Search Engine");

		// Set size and location of frame
		frame.setSize(400, 400);
		frame.setLocation(100, 150);

		// Close on exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sets labels and sizes
		JLabel titleLabel = new JLabel("Search Engine");
		titleLabel.setBounds(150, 10, 200, 50);
		JTextField searchField = new JTextField();

		// Set size of the text box
		searchField.setBounds(90, 100, 200, 30);
		
		// Buttons
		JButton button = new JButton("Search");
		button.setBounds(140, 150, 100, 30);
		
		// Set Background Color
		frame.getContentPane().setBackground( Color.cyan );
				
		// MenuBar additions
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuEdit = new JMenu("Edit");
		JMenu menuMaintenance = new JMenu("Maintenance");
		JMenu menuAbout = new JMenu("About");
		JMenuItem subMaintenanceMenu = new JMenuItem("Maintenance Panel");	
		
		// SubMenu additions
		menuMaintenance.add(subMaintenanceMenu);
		
		// Elements added
		frame.add(titleLabel);
		frame.add(searchField);
		frame.add(button);
		frame.setJMenuBar(menubar);
		frame.setLayout(null);
		frame.setVisible(true);
		
		// Adding MenuBar Items
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuMaintenance);
		menubar.add(menuAbout);
		
	
		// Creates 2nd form -Peter Quach's Creation
		subMaintenanceMenu.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		// Sub Frame
	        		JFrame f2 = new JFrame();
	        		f2.setVisible(true);
	            	f2.setSize(400, 400);
	            	f2.setLocationRelativeTo(null);
	        		
	        	}
	        });
		}
	
	//Main Class
	public static void main(String[] args) {
		createWindow();
		
	}

}
