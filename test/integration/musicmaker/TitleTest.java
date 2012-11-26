package musicmaker;
 
import musicmaker.TitleFactory;
import static org.junit.Assert.*;

import org.junit.Test;

public class TitleTest {

    @Test
    public void createTitleShouldContain2Words() {
      
        String title = TitleFactory.createTitle().generate();
         
        assertEquals(2, countWords(title));
    }
    
    @Test
    public void testCountWordsShouldReturn3Words() {
      	
        String title = "hej apa knas";
        assertEquals(3, countWords(title) );
    }
    
    private int countWords(String s)
    {
    	  int counter = 0;

    	    boolean word = false;
    	    int endOfLine = s.length() - 1;

    	    for (int i = 0; i < s.length(); i++) {
    	        // if the char is letter, word = true.
    	        if (Character.isLetter(s.charAt(i)) == true && i != endOfLine) {
    	            word = true;
    	            // if char isn't letter and there have been letters before (word
    	            // == true), counter goes up.
    	        } else if (Character.isLetter(s.charAt(i)) == false && word == true) {
    	            counter++;
    	            word = false;
    	            // last word of String, if it doesn't end with nonLetter it
    	            // Wouldn't count without this.
    	        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
    	            counter++;
    	        }
    	    }
    	    return counter;
    }

}
