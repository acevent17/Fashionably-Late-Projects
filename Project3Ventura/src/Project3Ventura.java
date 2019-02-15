import java.awt.Font;
import javax.swing.*;

public class Project3Ventura extends JFrame {
    
    public static void main(String [] args) {
        new Project3Ventura();
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
	    this.setSize(800, 675);
            
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
            Header.setBounds(300, -60, 300, 200);
            
            pan.add(Header);
            
            //Search button layout
            JButton searchBtn = new JButton("Search");
            searchBtn.setText("Search");
            searchBtn.setToolTipText("Search function");
            searchBtn.setBounds(355, 150, 75, 25);
            
            pan.add(searchBtn);
            
            // Maintenance button layout
            JButton maintBtn = new JButton("Search");
            maintBtn.setText("Maintenance");
            maintBtn.setToolTipText("Maintenance function");
            maintBtn.setBounds(50, 600, 110, 25);
            
            pan.add(maintBtn);
            
            //Text Box layout
            JTextField textBox = new JTextField("Type here", 15);
            textBox.setColumns(10);
            textBox.setText("");
            textBox.setToolTipText("Enter Search Terms here");
            textBox.setBounds(245, 100, 300, 25);
            
            pan.add(textBox);
           
            this.add(pan);
           
            //This displays the GUI and all components (Buttons, text area, ect.)
            this.setVisible(true);
    }

}
