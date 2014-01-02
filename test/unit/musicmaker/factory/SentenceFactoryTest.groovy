package musicmaker.factory

import org.junit.Test

import static junit.framework.TestCase.assertTrue

class SentenceFactoryTest {
    @Test
    void createSentenceShouldReturnSentence() {
        String sentence = SentenceFactory.createSentence()
        assertTrue sentence.length() > 10
    }

    @Test
    void getSentencePatternShouldReturnPattern() {
        String sentence  = SentenceFactory.getSentencePattern()
        assertTrue sentence.length() > 10
    }
}