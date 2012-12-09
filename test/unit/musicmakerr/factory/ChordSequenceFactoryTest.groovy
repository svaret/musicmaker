package musicmakerr.factory

import org.junit.Test
import musicmakerr.ChordSequence

import static groovy.util.GroovyTestCase.assertEquals

class ChordSequenceFactoryTest {

    @Test
    void createRandomSequenceShouldContainCorrectNumberOfChords() {
        int numberOfChords = 4
        ChordSequence chordSequence = ChordSequenceFactory.createRandomSequence(numberOfChords)

        assertEquals numberOfChords, chordSequence.getChords().size()
    }

}
