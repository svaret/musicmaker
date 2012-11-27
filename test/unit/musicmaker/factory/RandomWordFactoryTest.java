package musicmaker.factory;

import musicmaker.factory.RandomWordFactory;
import org.junit.Test;

import java.util.StringTokenizer;

import static org.junit.Assert.assertEquals;

public class RandomWordFactoryTest {

    @Test
    public void pickWordAmongTuneWordsShouldReturnOneWord() {
        String title = RandomWordFactory.pickAmongTuneWords();
        assertEquals(1, new StringTokenizer(title).countTokens());
    }

    @Test
    public void pickWordFromWebServiceShouldReturnOneWord() {
        String title = RandomWordFactory.pickFromWebService();
        assertEquals(1, new StringTokenizer(title).countTokens());
    }

}
