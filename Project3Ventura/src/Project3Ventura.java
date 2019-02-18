//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/* Changes:
 * Cleaned up code, fixed the ability to customize color + sub menu buttons.
 * TO BE DONE:
 * --Need to add table to maintenance frame
 *--about button needs to function
 *--IF CODE DOES NOT LOAD, CHANGE BUILD COMPATABILITY TO JAVA 10. (Right-click Project -> Properties -> Java Build Path
 * -> (Libraries Tab) -> Double-click JRE Library -> Alternate JRE -> (Set your java version)
 */
   

public class Project3Ventura {    
        
    private ButtonGroup group;
    
    private static void createWindow() {

        
        // Creates Window
        final JFrame frame = new JFrame("Search Engine");

        // Set size and location of frame
        frame.setSize(600, 400);
        frame.setLocation(100, 150);

        // Close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets labels and sizes
        JLabel titleLabel = new JLabel("Search Engine");
        titleLabel.setBounds(198, 10, 250, 50);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        JTextField searchField = new JTextField();
        
        //Flow Layout and Panel
        
        
        
        
        // Border 

        
        
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
        frame.getContentPane().setBackground( Color.cyan );
                
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
        
    
        // Creates 2nd form -Peter Quach's Creation
        subMaintenanceMenu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    // Sub Frame
                    JFrame f2 = new JFrame();
                    f2.setVisible(true);
                    f2.setSize(600, 400);
                    f2.setLocation(100, 150);
                    f2.setTitle("Search Engine Maintenance");
                    
                    f2.getContentPane().setBackground( Color.cyan );
                    
                    // Header and other labels
                    JLabel SubHeader = new JLabel("Search Engine - Index Maintenance");
                    SubHeader.setBounds(100, 5, 450, 50);
                    SubHeader.setFont(new Font("Serif", Font.BOLD, 26));
                    
                    JLabel labelFileNumber = new JLabel("Number of files indexed: 0");
                    labelFileNumber.setBounds(180, 340, 160, 30);
                    JLabel labelVersion = new JLabel("Search Engine Version 1.1");
                    labelVersion.setBounds(420, 340, 160, 30);                      
                    
                    // All the buttons on the bottom of the Maintenance Page
                   /* JButton buttonAddFile = new JButton("Add File...");
                    * buttonAddFile.setBounds(20, 280, 95, 30);
                
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
                    
                    f2.setJMenuBar(menubar);
                    
                    JMenuItem subAddFile = new JMenuItem("Add File");
                    menuFile.add(subAddFile);
                    JMenuItem subRebuild = new JMenuItem("Rebuild");
                    menuEdit.add(subRebuild);
                    JMenuItem subRemoveFile = new JMenuItem("Remove File");
                    menuEdit.add(subRemoveFile);
                    JMenuItem subResetWindow = new JMenuItem("Reset Window");
                    menuEdit.add(subResetWindow);
                    
                    // Elements added
                    f2.add(SubHeader);
                    f2.add(labelFileNumber);
                    f2.add(labelVersion);
                    // f2.add(buttonAddFile);
                    // f2.add(buttonRebuild);
                    // f2.add(buttonRemoveFile);
                    // f2.add(buttonResetWindow);

                    
                    
                    menubar.add(menuFile);
                    menubar.add(menuEdit);
                    menubar.add(menuAbout);
                    
                    f2.setLayout(null);
                    
                }
            });
        
        // Creates new frame for About page
        subAboutPage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
                // Sub Frame
                JFrame f3 = new JFrame();
                f3.setVisible(true);
                f3.setSize(400, 250);
                f3.setLocation(150, 200);
                f3.setTitle("About Page");
                
                //Labels
                JLabel headerLabel = new JLabel("About Search Engine");
                headerLabel.setBounds(100, 5, 450, 50);
                headerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                
                JLabel versionLabel = new JLabel("Version 1.0");
                versionLabel.setBounds(150, 25, 450, 50);
                versionLabel.setFont(new Font("Serif", Font.PLAIN, 15));
                
                JLabel byLabel = new JLabel("By:");
                byLabel.setBounds(173, 45, 450, 50);
                byLabel.setFont(new Font("Serif", Font.BOLD, 16));
                
                JLabel pqLabel = new JLabel("Peter Quach");
                pqLabel.setBounds(145, 65, 450, 50);
                pqLabel.setFont(new Font("Serif", Font.PLAIN, 16));
                
                JLabel mtLabel = new JLabel("Micheal Tarallo");
                mtLabel.setBounds(138, 85, 450, 50);
                mtLabel.setFont(new Font("Serif", Font.PLAIN, 16));
                
                JLabel jvLabel = new JLabel("Joshua Ventura");
                jvLabel.setBounds(140, 105, 450, 50);
                jvLabel.setFont(new Font("Serif", Font.PLAIN, 16));
                
                JLabel acLabel = new JLabel("Andres Cardenas");
                acLabel.setBounds(138, 125, 450, 50);
                acLabel.setFont(new Font("Serif", Font.PLAIN, 16));
                
                JLabel classLabel = new JLabel("Mr. Pollock Java II Advance (2019)");
                classLabel.setBounds(110, 145, 450, 50);
                classLabel.setFont(new Font("Serif", Font.PLAIN, 12));
                
                //elements added to the frame
                f3.add(headerLabel);
                f3.add(versionLabel);
                f3.add(byLabel);
                f3.add(pqLabel);
                f3.add(mtLabel);
                f3.add(jvLabel);
                f3.add(acLabel);
                f3.add(classLabel);
                
                f3.setLayout(null);
        	}
        });
    }
    
    //Main Class
    public static void main(String[] args) {
        createWindow();
        
    }

}
