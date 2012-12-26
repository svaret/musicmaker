package musicmaker.factory

import musicmaker.factory.RandomWordFactory
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class RandomWordFactoryTest {

    @Test
    void pickWordAmongTuneWordsShouldReturnOneWord() {
        String title = RandomWordFactory.pickAmongTuneWords()
        assertEquals 1, new StringTokenizer(title).countTokens()
    }

    @Test
    void pickWordFromWebServiceShouldReturnOneWord() {
        String title = RandomWordFactory.pickFromWebService()
        assertEquals 1, new StringTokenizer(title).countTokens()
    }

}
