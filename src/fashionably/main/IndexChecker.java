package fashionably.main;

import java.io.File;
import java.text.SimpleDateFormat;

/*
 * -This class will be used to check the indexed information for the following
 * information --any added files --any deleted files --changed files
 * 
 * --Future implementation: hopefully in the future the
 * method:IndexChangesCheck() can return a boolean variable if there are any
 * deleted, changed or added files and initiate an if statement to update the
 * index if returns "true"
 * 
 */

//Checks to see if added files are duplicates
//not working
// public static <T> boolean containsUnique(List<T> list) {
//	 Set<T> = new HashSet<>();
//	 
//	 for(T t: list) {
//		 if(!set.add(t))
//			 return false;
//	 }
// }

public class IndexChecker {

	/*
	 * Global Variables
	 */

	static File indexedFile = new File("Index.txt");

	// Gets Last Modified Date of selected file.
	public static void LastModified() {

		System.out.println("Before Format : " + indexedFile.lastModified());

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		System.out.println("After Format : " + dateFormat.format(indexedFile.lastModified()));

	}
}
// public static boolean IndexChangesCheck(){
// Body for the method goes here

// the false needs to be removed i the future
// boolean indexChanges = false;
// return indexChanges;
// };

// }
