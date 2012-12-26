package musicmakerr.factory

import musicmaker.factory.ToneSequenceFactory
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals
import musicmaker.ToneSequence

class ToneSequenceFactoryTest {

    @Test
    void createRandomSequenceShouldContainCorrectNumberOfTones() {
        int numberOfTones = 4
        ToneSequence toneSequence = ToneSequenceFactory.createRandomToneSequence(numberOfTones)

        assertEquals numberOfTones, toneSequence.getTones().size()
    }

}
