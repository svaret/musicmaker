package musicmakerr.factory

import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals
import musicmakerr.ToneSequence

class ToneSequenceFactoryTest {

    @Test
    void createRandomSequenceShouldContainCorrectNumberOfTones() {
        int numberOfTones = 4
        ToneSequence toneSequence = ToneSequenceFactory.createRandomToneSequence(numberOfTones)

        assertEquals numberOfTones, toneSequence.getTones().size()
    }

}
