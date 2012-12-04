package musicmakerr

import org.junit.Test
import static groovy.util.GroovyTestCase.assertEquals

class ChordSequenceTests {

    @Test
    void chordSequenceShouldContainOneMoreChordAfterAdd() {
        def chordSequence = new ChordSequence()
        def numberOfChordsBefore = chordSequence.getSize()
        chordSequence.add(Chord.A)

        assertEquals numberOfChordsBefore + 1, chordSequence.getSize()
    }

}
