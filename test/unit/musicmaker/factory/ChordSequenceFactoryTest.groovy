package musicmaker.factory

import musicmaker.Chord
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class ChordSequenceFactoryTest {

    @Test
    void createRandomSequenceShouldContainCorrectNumberOfChords() {
        int numberOfChords = 4
        List<Chord> chords = ChordSequenceFactory.createRandomSequence(numberOfChords)

        assertEquals numberOfChords, chords.size()
    }

}
