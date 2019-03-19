package fashionably.main;

import static java.lang.System.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;


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
	
	// How to get the file last modified date
	public static void LastModified() {
		
		File file1 = new File("JSON.txt");
		File file2 = new File("JSON.txt");
		
		System.out.println("Before Format : " + file1.lastModified());
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			
		System.out.println("After Format : " + sdf.format(file1.lastModified()));	
		
//		boolean compare1and2 = FileUtils.contentEquals(file1, file2);
//		
//		System.out.println("Are File 1 and File 2 similar?" + compare1and2);
//		
//		if(filepath.equals() != filepath) {
//			System.out.println("File has changed!");
//		}else {
//			System.out.println("Duplicate File");
//		}
//		
	}
}
// public static boolean IndexChangesCheck(){
// Body for the method goes here

// the false needs to be removed i the future
// boolean indexChanges = false;
// return indexChanges;
//	};

//}
