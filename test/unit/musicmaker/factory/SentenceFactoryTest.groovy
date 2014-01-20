package musicmaker.factory

import musicmaker.Sentence
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class SentenceFactoryTest {

    @Test
    void createSentenceShouldContainCorrectNumberOfSentences() {
        int numberOfSentences= 4
        List<Sentence> sentences = SentenceFactory.createSentences(numberOfSentences)

        assertEquals numberOfSentences, sentences.size()

        (0..3).each{
        System.out.println(sentences[it].wordString)
        }
    }

}
