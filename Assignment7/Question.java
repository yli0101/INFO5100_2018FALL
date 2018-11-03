package question2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Question {
	public static void main(String[] arg0) throws IOException {
		File file = new File("/Users/Documents/Assignment7/Test.Java");
		parse(file);
	}
	
	public static void parse(File file) throws IOException{
		   RandomAccessFile input = null;
		   String line = null;
		   try {
		       input = new RandomAccessFile(file, "r");
		       while ((line = input.readLine()) != null) {
		           System.out.println(line);
		       }
		       return;
		   } finally {
		       if (input != null) {
		           input.close();
		       }
		   }
		}

}
