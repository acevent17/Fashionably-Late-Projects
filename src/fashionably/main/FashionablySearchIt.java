/*
 * Info: Current Version: 1.3.0-55
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
 * --N/A
 * 
 * Current Issues are displayed below:
 * --N/A
 * 
 * 
 * 
 * Resolved Issues:
 * --N/A
 * 
 */

package fashionably.main;

/*
 * Due to potential build path changes when committing amongst group members, 
 * intial execution of program may 'glitch'. 
 * To fix, simply close and re-execute the program.
 */

// Importing classes from framework package
import fashionably.framework.SearchItFramework;

public class FashionablySearchIt {
	public static void main(String args[]) {

		// Handles Framework of Maintenance Page
		SearchItFramework.createSearchEngine();

		// Creates Index File if not found
		CreateIndexFile create = new CreateIndexFile();
		create.openIndexFile();
	}
}
