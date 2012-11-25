package musicmaker;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.StringTokenizer;

public class TitleTest {

    @Test
    public void createTitleShouldContainTwoWords() {
        String title = RandomWordFactory.pickAmongTuneWords();
        assertEquals(2, new StringTokenizer(title).countTokens());
    }

}
