package EntireScript;

import java.io.BufferedReader;
import java.io.IOException;
//Input stream loaded 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
//imported for URL functionality
import java.net.URL;
import java.util.Scanner;
import java.lang.String ;

public class Complete{
	
	//This is the URL we are going to be using with out own API key
	public static final String SEARCH_Omdb = 
			//392b4f7b THIS IS OUR API KEY
			//TITLE and APIKEY are passed, below (LINES), as arguments
			"http://www.omdbapi.com/?CODE=FILMQUERY&apikey=OMDBKEY";
	
	public static final String SEARCH_Tmdb = 
			//392b4f7b THIS IS OUR API KEY
			//TITLE and APIKEY are passed, below (LINES), as arguments
			"https://api.themoviedb.org/3/FILMQUERY2/550?api_key=20724b45c58f00fd577ff46284718a797";
	
	
	public static String clientRequest(String requestUrl) {
		//Concatenates all of the JSON code from the Omdb server
		//The JSON "Raw data" is just a string
		StringBuffer concatenate = new StringBuffer();
		
		//requestURL throws and exception, so we surround it with a try catch
		try {
		URL url = new URL(requestUrl);
		
		//Then open up a connection to that URL
		//url.openConnection also throws an exception ((2) added a catch clause)
		HttpURLConnection OmdbServer = 
				(HttpURLConnection) url.openConnection();
		
		//In this instance the connection is configured to be a GET
		OmdbServer.setRequestMethod("GET");
		OmdbServer.setRequestProperty("Accept",  "*/*");
		OmdbServer.setRequestProperty("Content-Type", "application/jason; charset=UTF-8");
		
		//This input will be read byte by byte and concatenated to our local data as a final string
		InputStream stream = OmdbServer.getInputStream();
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader buffer = new BufferedReader(reader);
		
		//Now the buffer is all set up, we can start reading from it
		//This is where we concatenate it into a local string
		String line;
		while ((line = buffer.readLine()) != null) {
			concatenate.append(line);
		}
		buffer.close();
		OmdbServer.disconnect();
		
		} catch (MalformedURLException e) {
			//TODO auto-generated catch block
			e.printStackTrace();
		//This is the catch clause surrounding (2)
		} catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return concatenate.toString();
	}
	
	//A: SEARCH FUNCTION (First Function) 
	//This fulfils a user story "As a user, I want to search etc..."
	public static String movieTitleSearch (String MyChoice, String SelectedFilm, String MyKey) {
		String requestUrl = SEARCH_Omdb
				.replaceAll("FILMQUERY", SelectedFilm)
				.replaceAll("OMDBKEY", MyKey)
				.replaceAll("CODE", MyChoice);
		
		return clientRequest(requestUrl);
	}
	//STACK DATA STRUCTURE
	
	//B: WISHLIST FUNCTION
	
	//C: COMMENT FUNCTION
	
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		String a;
		
		Scanner sc = new Scanner(System.in);
		
		//User input
		System.out.println("----------Choose a film----------");
		a = sc.nextLine();
		String newName = a.replaceAll(" ", "+");
		System.out.println("Name:\n" + newName + "\n");
		
		//1. Search by film title (t)
		System.out.println("----------Film details----------\n");
		//Combines user input with URL
		String outputTitle = Complete.movieTitleSearch("t", newName,  "392b4f7b"); //392b4f7b THIS IS OUR API KEY
		
		//Puts the string into an array
		String result1 = outputTitle;
		String[] resultarray1 = result1.substring(1,result1.length()).split(",");
		for (String string : resultarray1) {
			System.out.println(string);	
		}
		
		//2. All other searches associated with film title
		System.out.println("\n----------Other potential film searches:----------\n");
		
		//Combines user input with URL
		String outputSearches = Complete.movieTitleSearch("s", newName,  "392b4f7b"); //392b4f7b THIS IS OUR API KEY
		
		//Puts the string into an array
		String result2 = outputSearches;
		String[] resultarray2 = result2.substring(1,result2.length()).split(",");
		for (String string : resultarray2) {
			System.out.println(string);
		}
		/*
		System.out.println("\n----------Enter IMDB ID:----------\n");
		String outputIMDBID = OmdbClientServerConnectivity.movieTitleSearch("s", newName,  "392b4f7b"); //392b4f7b THIS IS OUR API KEY]
		
		
		System.out.println("\n----------Search Tmdb?: Y or N ----------\n");
		String outputTMDB = OmdbClientServerConnectivity.movieTitleSearch(newName);
		*/
		
	}
}