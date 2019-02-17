import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
/*
 * Unused imports (These may be needed later)
 * import java.awt.Event.*; (Used for actionlistener)
 * 
 */

public class Project3Ventura extends JFrame {
    
	/* moved Project3Ventura constructor into Main  
	*  Current issue with main JFrame. It take a while too load the Textbox and the search 
	*  button. The search button is stuck next to the header and will not move even though 
	*  bounds are constantly changed. Textbox and RadioButton wont pop up immediately and 
	*  will only pop up if hover over or click on JFrame.
	*  I left Joshua code commented in the bottom commented until we figure out
	*  what needs to be done *Peter - 2/16/19
	*/
	
    public static void main(String [] args) {
    	
    	// Frame layout 
    	JFrame f = new JFrame("Search Engine");
    	f.setVisible(true);
    	f.setSize(800, 600);
    	f.setLocationRelativeTo(null);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//JPanel set up. Sets a panel to add components to.
    	JPanel pan = new JPanel();
    	f.add(pan);
    	
    	// Header layout
    	JLabel Header = new JLabel();
    	Header.setText("Search Engine");
        Header.setFont(new Font("Serif", Font.BOLD, 30));
        Header.setBounds(300, -50, 300, 200);
        pan.add(Header);
        
        
        // Menu Bar layout 
        JMenuBar menubar = new JMenuBar();
        f.setJMenuBar(menubar);
        JMenu file = new JMenu("File");
        menubar.add(file);
      
        JMenu edit = new JMenu("Edit");
        menubar.add(edit);
      
        JMenu maintenance = new JMenu("Maintnance");
        menubar.add(maintenance);
        
        //added a Menu item Maintenance view to open the sub Jframe 
        JMenuItem maintenanceView = new JMenuItem("Maintenance View");
        maintenance.add(maintenanceView);
      
        JMenu about = new JMenu("About");
        menubar.add(about);
        
        //ActionListener when the menu item Maintenance view is clicked it will open the
        //sub frame
        maintenanceView.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		// Sub Frame
        		JFrame f2 = new JFrame();
        		f2.setVisible(true);
            	f2.setSize(800, 600);
            	f2.setLocationRelativeTo(null);
        		
        	}
        });
        
        // Search Button Layout
        JButton searchBtn = new JButton("Search");
        searchBtn.setText("Search");
        searchBtn.setToolTipText("Search function");
        searchBtn.setBounds(355, 125, 75, 25);
      
        pan.add(searchBtn);
        
        // Textfield Layout
        JTextField textBox = new JTextField("Type here", 15);
        textBox.setColumns(15);
        textBox.setText("");
        textBox.setToolTipText("Enter Search Terms here");
        textBox.setBounds(190, 80, 400, 25);
      
        pan.add(textBox);
        
        //Radio Button layout  
        JRadioButton allSearch = new JRadioButton("All Search Terms", true);
        allSearch.setBounds(250, 180, 125, 25);
      
        pan.add(allSearch);
      
      
        JRadioButton exact = new JRadioButton("Exact Phrase", false);
        exact.setBounds(410, 180, 125, 25);
      
        pan.add(exact);
      
        ButtonGroup group = new ButtonGroup();
        group.add(allSearch);
        group.add(exact);
    	
    }
    
//    public Project3Ventura() {
//        
//        // components include: Buttons, Frame, Labels, ect..
//        // setSize - sets size of components
//        // setTitle - sets the title bar's text
//        // setText - sets the text for the component 
//        // setFont - Sets the font of the text
//        // setBounds - sets the bounds (position) of components
//        // setToolTipText - sets a tooltip to components (tool tips are text 
//        //                  that shows when hovered over with the mouse)
//        // setVisible - sets all components within range to show upon running
//        
//    	
//        	
//        // Frame layout 
//    		this.setSize(800, 600);
//    		
//    	
//        // Sets Frame position to always start centered
//    		this.setLocationRelativeTo(null);
//        
//        // closes entire program upon exit
//    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    		
//    		this.setTitle("Search Engine");
//    		
//    	/* I couldn't seem to get this to work below,
//    	 *	this.getContentPane().setBackground(Color.BLUE);
//    	 *
//    	 */ 
//            
//        //JPanel set up. Sets a panel to add components to.
//            JPanel pan = new JPanel();
//            pan.setLayout(null);
//            
//        // Header layout
//            JLabel Header = new JLabel("");
//            Header.setText("Search Engine");
//            Header.setFont(new Font("Serif", Font.BOLD, 30));
//            Header.setBounds(300, -50, 300, 200);
//            
//            pan.add(Header);
//            
//        // Menu Bar layout    
//            JMenuBar menubar = new JMenuBar();
//            this.setJMenuBar(menubar);
//            
//            JMenu file = new JMenu("File");
//            menubar.add(file);
//            
//            JMenu edit = new JMenu("Edit");
//            menubar.add(edit);
//            
//            JMenu maintenance = new JMenu("Maintnance");
//            menubar.add(maintenance);
//            
//            JMenu about = new JMenu("About");
//            menubar.add(about);
//            
//            
//        //Search button layout
//            JButton searchBtn = new JButton("Search");
//            searchBtn.setText("Search");
//            searchBtn.setToolTipText("Search function");
//            searchBtn.setBounds(355, 125, 75, 25);
//            
//            pan.add(searchBtn);
//            
//        /* This button was replaced with a menu bar.
//         * It is being kept in case someone else wants to use it.
//         * Maintenance button layout
//         *   JButton maintBtn = new JButton();
//         *   maintBtn.setText("Maintenance");
//         *   maintBtn.setToolTipText("Maintenance function");
//         *   maintBtn.setBounds(50, 590, 110, 25);
//         *   
//         *   pan.add(maintBtn);
//         */ 
//            
//        /* This button was replaced with a menu bar.
//         * It is being kept in case someone else wants to use it.
//         * About button layout
//         *    JButton aboutBtn = new JButton();
//         *    aboutBtn.setText("About");
//         *    aboutBtn.setToolTipText("Displays information about the Search Engine");
//         *    aboutBtn.setBounds(625, 590, 110, 25);
//         *    
//         *    pan.add(aboutBtn);
//         */
//            
//        //Text Box layout
//            JTextField textBox = new JTextField("Type here", 15);
//            textBox.setColumns(15);
//            textBox.setText("");
//            textBox.setToolTipText("Enter Search Terms here");
//            textBox.setBounds(190, 80, 400, 25);
//            
//            pan.add(textBox);
//            
//        //Radio Button layout  
//            JRadioButton allSearch = new JRadioButton("All Search Terms", true);
//            allSearch.setBounds(250, 180, 125, 25);
//            
//            this.add(allSearch);
//            
//            
//            JRadioButton exact = new JRadioButton("Exact Phrase", false);
//            exact.setBounds(410, 180, 125, 25);
//            
//            this.add(exact);
//            
//            group = new ButtonGroup();
//            group.add(allSearch);
//            group.add(exact);
//            
//            this.add(pan);
//        //This displays the GUI and all components (Buttons, text area, ect.)
//            this.setVisible(true);
    }

//}

