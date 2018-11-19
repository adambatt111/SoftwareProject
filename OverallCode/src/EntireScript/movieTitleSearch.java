package EntireScript;

public class movieTitleSearch {
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
