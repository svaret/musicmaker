package unit;

import static org.junit.Assert.*;
import java.util.StringTokenizer;
import musicmaker.RandomWordFactory;

import org.junit.Test;

public class TitleTest {

    @Test
    public void createTitleShouldContainTwoWords() {
        String title = RandomWordFactory.pickAmongTuneWords();
        assertEquals(2, new StringTokenizer(title).countTokens());
    }

}
