package musicmaker.factory

import musicmaker.Sentence
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class SentenceFactoryTest {

    @Test
    void createSentenceShouldContainCorrectNumberOfSentences() {
        int numberOfSentences= 10
        List<Sentence> sentences = SentenceFactory.createSentences(numberOfSentences)

        assertEquals numberOfSentences, sentences.size()

        (0..9).each{
        System.out.println(sentences[it].wordString)
        }
    }

}
