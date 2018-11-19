package EntireScript;

import java.util.Scanner;

public interface Database {
	//This is the URL we are going to be using with out own API key
			public static final String SEARCH_Omdb = 
					//392b4f7b THIS IS OUR API KEY
					//TITLE and APIKEY are passed, below (LINES), as arguments
					"http://www.omdbapi.com/?CODE=FILMQUERY&apikey=OMDBKEY";
			
			public static final String SEARCH_Tmdb = 
					//392b4f7b THIS IS OUR API KEY
					//TITLE and APIKEY are passed, below (LINES), as arguments
					"https://api.themoviedb.org/3/FILMQUERY2/550?api_key=20724b45c58f00fd577ff46284718a797";
			
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
				System.out.println("\n----------Search Tmdb?: Y or N ----------\n");
				String outputTMDB = OmdbClientServerConnectivity.movieTitleSearch(newName);
				*/
			}
}
