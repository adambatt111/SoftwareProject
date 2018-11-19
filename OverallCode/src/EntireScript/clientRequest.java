package EntireScript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class clientRequest {
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
}
