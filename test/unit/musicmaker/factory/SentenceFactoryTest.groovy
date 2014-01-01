package musicmaker.factory

import musicmaker.factory.SentenceFactory
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals
import static junit.framework.TestCase.assertTrue

class SentenceFactoryTest {

    @Test
    void createSenentenceShouldReturnSentenence() {
        String sentence = SentenceFactory.getSentence()
        assertTrue(sentence.length() > 10)
    }

    @Test
    void getSenentencePatternShouldReturnPattern() {
        String sentence  = SentenceFactory.getSentencePattern()
        assertTrue(sentence.length() > 10)
    }

}
