package musicmaker

import musicmaker.Chord
import org.junit.Test

class ChordTests {
    @Test
    void getRandomChordShouldBeOneAmongContainingChords() {
       assert Chord.CHORDS.contains(Chord.getRandom())
    }
}
