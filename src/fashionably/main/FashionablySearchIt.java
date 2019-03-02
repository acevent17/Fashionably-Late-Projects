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
		
		/*
		 * --This method is called from class:IndexChecker to check 
		 * for any changes to the indexed information
		 */
		boolean indexBoolean = IndexChecker.IndexChangesCheck();
		if (indexBoolean = true){
			//update index file
		}
		else {
			//do nothing
		};
		

		
		
		//Main part of the Program
		SearchItFramework.createSearchEngine();
		
		/*
		 * -This hook will be used in the future to store the last, most updated table information into
		 * persistent storage.
		 * -right now it only uses the printed message to show capability
		 */
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Shut Down Hook Test Message! - at this moment the indexed file should be saved!");
			}
		});

	}
}
