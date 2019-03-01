/*
 * Class dedicated to About Frame Functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for About functionality
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
	public static void createSubAbout() {
		// Sub About Frame
		JFrame aboutSubFrame = new JFrame();
		aboutSubFrame.setVisible(true);
		aboutSubFrame.setSize(400, 250);
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

		//
		aboutSubFrame.setLayout(null);
	}
}
