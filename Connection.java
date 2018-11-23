


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection {
	public static void main(String[] args) throws IOException {
		
			URL url = new URL("http://api.themoviedb.org/3/movie/550?api_key=20724b45c58f00fd577f46284718a797");
			 HttpURLConnection con = (HttpURLConnection) url.openConnection();
			 con.setDoOutput(true);
			 con.setRequestMethod("GET");
			 con.setRequestProperty("Content-Type", "application/json");
			 
			 BufferedReader buffer = new BufferedReader(new InputStreamReader((con.getInputStream())));
			 
			 String output;
			 
			 System.out.println("Output from Server . . . . n");
			 
			 while ((output = buffer.readLine()) !=null) {
				 System.out.println(output);
			 }
	}
}
		
