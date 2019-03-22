/*
 * Class dedicated to About Frame Functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for About functionality
 * --Adjusted Positioning of Group Names
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

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SearchItAbout {

	/*
	 *  Global Variables
	 */
	
	
	// Frame
	static JFrame aboutSubFrame = new JFrame();

	// Label
	static JLabel headerLabel = new JLabel("Fashionably Late");
	static JLabel versionLabel = new JLabel("Version 1.2.0");
	static JLabel byLabel = new JLabel("By:");
	static JLabel pqLabel = new JLabel("Peter Quach");
	static JLabel mtLabel = new JLabel("Michael Tarallo");
	static JLabel jvLabel = new JLabel("Joshua Ventura");
	static JLabel acLabel = new JLabel("Andres Cardenas");
	static JLabel classLabel = new JLabel("Mr. Pollock Java II COP-2805C");

	public static void createSubAbout() {
		// Sub About Frame
		aboutSubFrame.setVisible(true);
		aboutSubFrame.setSize(400, 250);
		aboutSubFrame.setTitle("About Page");
		aboutSubFrame.setLocationRelativeTo(null);

		// Labels
		headerLabel.setBounds(20, 5, 450, 50);
		headerLabel.setFont(new Font("Serif", Font.BOLD, 20));

		versionLabel.setBounds(300, 165, 450, 50);
		versionLabel.setFont(new Font("Serif", Font.PLAIN, 15));

		byLabel.setBounds(20, 35, 450, 50);
		byLabel.setFont(new Font("Serif", Font.BOLD, 16));

		pqLabel.setBounds(20, 55, 450, 50);
		pqLabel.setFont(new Font("Serif", Font.PLAIN, 16));

		mtLabel.setBounds(20, 75, 450, 50);
		mtLabel.setFont(new Font("Serif", Font.PLAIN, 16));

		jvLabel.setBounds(20, 95, 450, 50);
		jvLabel.setFont(new Font("Serif", Font.PLAIN, 16));

		acLabel.setBounds(20, 115, 450, 50);
		acLabel.setFont(new Font("Serif", Font.PLAIN, 16));

		classLabel.setBounds(20, 145, 450, 50);
		classLabel.setFont(new Font("Serif", Font.PLAIN, 12));

		// Elements added to About frame
		aboutSubFrame.add(headerLabel);
		aboutSubFrame.add(byLabel);
		aboutSubFrame.add(pqLabel);
		aboutSubFrame.add(mtLabel);
		aboutSubFrame.add(jvLabel);
		aboutSubFrame.add(acLabel);
		aboutSubFrame.add(classLabel);
		aboutSubFrame.add(versionLabel);

		// Centers About Frame
		aboutSubFrame.setLayout(null);
	}
}
