package musicmaker.factory

import musicmaker.Tone
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class ToneSequenceFactoryTest {

    @Test
    void createRandomSequenceShouldContainCorrectNumberOfTones() {
        int numberOfTones = 4
        List<Tone> tones = ToneSequenceFactory.createRandomToneSequence(numberOfTones)

        assertEquals numberOfTones, tones.size()
    }

}
