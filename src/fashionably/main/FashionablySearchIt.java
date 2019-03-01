/*
 * Info: Current Version: 1.2.0
 * 
 * Created separate classes to clean up code and better organize / distribute work amongst group members.
 * Make note of the package names and imports.
 * Please add changes, issues, and resolved issues in comments per class.
 * 
 * Importing a package syntax:
 * package <package name>;
 * 
 * Importing a class to class:
 * import <package name>.<class>;
 */

/*
 * Class dedicated to be Main Functionality of the Search Engine
 * 
 * 
 * Changes are displayed below:
 * --Created class specifically for Main functionality
 * 
 * 
 * Current Issues are displayed below:
 * --Table needs to import file path into data field
 * --Table needs to save last import path when closing
 * --When Search Engine Initializes, files need to be checked and compared to date of being added to table
 * 
 * 
 * Resolved Issues:
 * --TBA
 * 
 */

package fashionably.main;

// Importing classes from framework package
import fashionably.framework.SearchItFramework;

public class FashionablySearchIt {
	public static void main(String args[]) {
		SearchItFramework.createSearchEngine();

	}
}
