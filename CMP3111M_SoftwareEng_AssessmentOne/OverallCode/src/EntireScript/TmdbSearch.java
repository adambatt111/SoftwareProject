package EntireScript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TmdbSearch extends Complete {
	
	public static final String SEARCH_Tmdb = 
			//392b4f7b THIS IS OUR API KEY
			//TITLE and APIKEY are passed, below (LINES), as arguments
			"https://api.themoviedb.org/3/FILMQUERY/500?api_key=20724b45c58f00fd577ff46284718a797";
		
		// OPTION B: TMDB SERVER
		
		public static String clientRequest2(String requestUrl2) {
			//Concatenates all of the JSON code from the Tmdb server
			//The JSON "Raw data" is just a string
			StringBuffer concatenate2 = new StringBuffer();
			
			//requestURL throws and exception, so we surround it with a try catch
			try {
			URL url2 = new URL(requestUrl2);
		
		//Then open up a connection to that URL
		//url.openConnection also throws an exception ((2) added a catch clause)
		HttpURLConnection TmdbServer = 
				(HttpURLConnection) url2.openConnection();

		//In this instance the connection is configured to be a GET
		TmdbServer.setRequestMethod("GET");
		TmdbServer.setRequestProperty("Accept",  "*/*");
		TmdbServer.setRequestProperty("Content-Type", "application/jason; charset=UTF-8");
		
		//This input will be read byte by byte and concatenated to our local data as a final string
		InputStream stream2 = TmdbServer.getInputStream();
		InputStreamReader reader2 = new InputStreamReader(stream2);
		BufferedReader buffer2 = new BufferedReader(reader2);
		
		//Now the buffer is all set up, we can start reading from it
		//This is where we concatenate it into a local string
		String line2;
		while ((line2 = buffer2.readLine()) != null) {
			concatenate2.append(line2);
		}
		buffer2.close();
		TmdbServer.disconnect();
		
		
		// OPTION B:  EXCEPTIONS
		
		} catch (MalformedURLException e) {
			//TODO auto-generated catch block
			e.printStackTrace();
		//This is the catch clause surrounding (2)
		} catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return concatenate2.toString();
	}
		
	
	//B: SEARCH FUNCTION (Second Function) 
	//This fulfils a user story "As a user, I want to search etc..."
	public static String movieTitleSearch2 (String MyChoice2, String SelectedFilm2) {
		String requestUrl2 = SEARCH_Tmdb
				.replaceAll("FILMQUERY", SelectedFilm2)
		
		return clientRequest2(requestUrl2);
	}


}
