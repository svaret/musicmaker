package musicmaker;
 
import musicmaker.TitleFactory;
import static org.junit.Assert.*;

import org.junit.Test;

public class TitleTest {

    @Test
    public void createTitleShouldContainTwoWords() {
        String title = RandomWordFactory.pickAmongTuneWords();
        assertEquals(2, new StringTokenizer(title).countTokens());
    }

}
