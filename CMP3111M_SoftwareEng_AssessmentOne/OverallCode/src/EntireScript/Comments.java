package EntireScript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class Comments {

	//set up for the user input
    Reader r = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(r);
    String str = null;

    try {
            //prompt the user to input data
            System.out.println("Please type your comment...");
            PrintWriter writer = new PrintWriter("Comment.txt", "UTF-8");
            while((str = br.readLine())!=null)
            {
            //save the line
            writer.println(str);
            }
            writer.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
