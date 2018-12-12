package EntireScript;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
//Input stream loaded 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
//imported for URL functionality
import java.net.URL;
import java.util.Scanner;
import java.lang.String;
import static java.lang.System.*;

public class Complete{

	
	// C: MAIN CALLBACK INTERFACE
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		String a;
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		OmdbSearch Od = new OmdbSearch();
		
		//User input
		System.out.println("----------Choose a film----------");
		a = sc1.nextLine();
		String filmName = a.replaceAll(" ", "+");
		System.out.println("Name:\n" + filmName + "\n");
		
		//1. Search by film title (t)
		System.out.println("----------Film details----------\n");
		//Combines user input with URL
		String outputTitle = Complete.movieTitleSearch("t", filmName,  "392b4f7b"); //392b4f7b THIS IS OUR API KEY
		
		//Puts the string into an array
		String result1 = outputTitle;
		String[] resultarray1 = result1.substring(1,result1.length()).split(",");
		for (String string : resultarray1) {
			System.out.println(string);	
		}
		
		//2. All other searches associated with film title
		System.out.println("\n----------Other potential film searches:----------\n");
		
		//Combines user input with URL
		String outputSearches = Complete.movieTitleSearch("s", filmName,  "392b4f7b"); //392b4f7b THIS IS OUR API KEY
		
		//Puts the string into an array
		String result2 = outputSearches;
		String[] resultarray2 = result2.substring(1,result2.length()).split(",");
		for (String string : resultarray2) {
			System.out.println(string);
		}
		
		// IF !!!!
		
		//3. Select data from Tmdb

		TmdbSearch Td = new TmdbSearch();
		
		//4. Search by film title (t)
		System.out.println("----------Film details----------\n");
		//Combines user input with URL
		String outputTitle2 = Complete.movieTitleSearch2(filmName); //392b4f7b THIS IS OUR API KEY
		
		//Puts the string into an array
		String result3 = outputTitle2;
		String[] resultarray3 = result3.substring(1,result3.length()).split(",");
		for (String string : resultarray1) {
			System.out.println(string);	
		}
		
		// ELSE !!!!
		
		//6. Write film to Wishlist to wishlist.file
		System.out.println("\n----------Film search has been added to Wishlist:----------\n");
		
		// CALL COMMENT CLASS HERE
		Comments CS = new Comments();
		
		// ELSE !!!!
		
		//5. Write Comments to comment.file
		System.out.println("\n----------Add comment to the film log:----------\n");
		
		// CALL WISHLIST CLASS HERE
		Wishlist WL = new Wishlist();
		
	}

	private static String movieTitleSearch2(String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String movieTitleSearch(String string, String newName, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
}
