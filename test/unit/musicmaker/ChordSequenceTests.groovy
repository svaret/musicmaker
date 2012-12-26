package musicmaker

import musicmaker.Chord
import musicmaker.ChordSequence
import org.junit.Test
import static groovy.util.GroovyTestCase.assertEquals

class ChordSequenceTests {

    @Test
    void chordSequenceShouldContainOneMoreChordAfterAdd() {
        def chordSequence = new ChordSequence()
        def numberOfChordsBefore = chordSequence.size
        chordSequence.add(Chord.A)

        assertEquals numberOfChordsBefore + 1, chordSequence.size
    }

}
