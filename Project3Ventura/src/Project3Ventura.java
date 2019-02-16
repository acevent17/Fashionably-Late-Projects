import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
 * Unused imports (These may be needed later)
 * import java.awt.Event.*; (Used for actionlistener)
 * 
 */

public class Project3Ventura extends JFrame {
    
	private ButtonGroup group;
	
    public static void main(String [] args) {
        new Project3Ventura();
        
        //Creation of a modifiable second window.
        Frame frame = new Frame("Title");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
      
        frame.setVisible(true);

    }
    
    public Project3Ventura() {
        
        // components include: Buttons, Frame, Labels, ect..
        // setSize - sets size of components
        // setTitle - sets the title bar's text
        // setText - sets the text for the component 
        // setFont - Sets the font of the text
        // setBounds - sets the bounds (position) of components
        // setToolTipText - sets a tooltip to components (tool tips are text 
        //                  that shows when hovered over with the mouse)
        // setVisible - sets all components within range to show upon running
        
    	
        	
        // Frame layout 
    		this.setSize(800, 600);
    		
        // Sets Frame position to always start centered
    		this.setLocationRelativeTo(null);
        
        // closes entire program upon exit
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		
    		this.setTitle("Search Engine");
    		            
        //JPanel set up. Sets a panel to add components to.
            JPanel pan = new JPanel();
            pan.setLayout(null);
            
        // Header layout
            JLabel Header = new JLabel("");
            Header.setText("Search Engine");
            Header.setFont(new Font("Serif", Font.BOLD, 30));
            Header.setBounds(300, -50, 300, 200);
            
            pan.add(Header);
            
        // Menu Bar layout    
            JMenuBar menubar = new JMenuBar();
            this.setJMenuBar(menubar);
            
            JMenu file = new JMenu("File");
            menubar.add(file);
            
            JMenu edit = new JMenu("Edit");
            menubar.add(edit);
            
            JMenu maintenance = new JMenu("Maintnance");
            menubar.add(maintenance);
            
            JMenu about = new JMenu("About");
            menubar.add(about);
            
            
        //Search button layout
            JButton searchBtn = new JButton("Search");
            searchBtn.setText("Search");
            searchBtn.setToolTipText("Search function");
            searchBtn.setBounds(355, 125, 75, 25);
            
            pan.add(searchBtn);
            
        /* This button was replaced with a menu bar.
         * It is being kept in case someone else wants to use it.
         * Maintenance button layout
         *   JButton maintBtn = new JButton();
         *   maintBtn.setText("Maintenance");
         *   maintBtn.setToolTipText("Maintenance function");
         *   maintBtn.setBounds(50, 590, 110, 25);
         *   
         *   pan.add(maintBtn);
         */ 
            
        /* This button was replaced with a menu bar.
         * It is being kept in case someone else wants to use it.
         * About button layout
         *    JButton aboutBtn = new JButton();
         *    aboutBtn.setText("About");
         *    aboutBtn.setToolTipText("Displays information about the Search Engine");
         *    aboutBtn.setBounds(625, 590, 110, 25);
         *    
         *    pan.add(aboutBtn);
         */
            
        //Text Box layout
            JTextField textBox = new JTextField("Type here", 15);
            textBox.setColumns(15);
            textBox.setText("");
            textBox.setToolTipText("Enter Search Terms here");
            textBox.setBounds(190, 80, 400, 25);
            
            pan.add(textBox);
            
        //Radio Button layout  
            JRadioButton allSearch = new JRadioButton("All Search Terms", true);
            allSearch.setBounds(250, 180, 125, 25);
            
            this.add(allSearch);
            
            
            JRadioButton exact = new JRadioButton("Exact Phrase", false);
            exact.setBounds(410, 180, 125, 25);
            
            this.add(exact);
            
            group = new ButtonGroup();
            group.add(allSearch);
            group.add(exact);
            
            this.add(pan);
        //This displays the GUI and all components (Buttons, text area, ect.)
            this.setVisible(true);
    }

}

