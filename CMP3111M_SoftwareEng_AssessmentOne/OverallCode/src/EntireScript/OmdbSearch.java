package EntireScript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OmdbSearch extends Complete {
	//This is the URL we are going to be using with out own API key
		public static final String SEARCH_Omdb = 
				//392b4f7b THIS IS OUR API KEY
				//TITLE and APIKEY are passed, below (LINES), as arguments
				"http://www.omdbapi.com/?CODE=FILMQUERY&apikey=OMDBKEY";
		
		// OPTION A: OMDB SERVER
		
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
			
			// OPTION A: EXCEPTIONS
			
			buffer.close();
			OmdbServer.disconnect();
			}
			catch (MalformedURLException e) {
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
}
