package EntireScript;

import static java.lang.System.out;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Wishlist {	
	try {
		FileWriter fw = new FileWriter("Wishlist.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		//Result array is output string of Omdb search
		pw.println(resultarray1); // CALLS FROM OMDB SEARCH
	} catch (IOException e) {
		out.println("ERROR!");
	}
}
