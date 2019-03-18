package fashionably.main;

import java.io.File;
import java.nio.file.*;
import java.text.SimpleDateFormat;

public class LastModified {

	static File file1 = new File("c:\\logfile.log");
	System.out.println("Before Format : "+ file.lastModified()));
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	System.out.println("After Format : " + sdf.format(file.lastModified()));
	
}