package musicmaker.factory

import musicmaker.factory.ChordSequenceFactory
import org.junit.Test
import musicmaker.ChordSequence

import static groovy.util.GroovyTestCase.assertEquals

class ChordSequenceFactoryTest {

    @Test
    void createRandomSequenceShouldContainCorrectNumberOfChords() {
        int numberOfChords = 4
        ChordSequence chordSequence = ChordSequenceFactory.createRandomSequence(numberOfChords)

        assertEquals numberOfChords, chordSequence.getChords().size()
    }

}
