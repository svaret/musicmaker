package musicmaker

import musicmaker.Lyrics
import org.junit.Test
import static groovy.util.GroovyTestCase.assertEquals

class LyricsTests {
    @Test
    void getWordsShouldContainFiveWords() {
        def lyrics = new Lyrics(5)

        assertEquals 5, lyrics.words.size()

    }
}