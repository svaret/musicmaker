package musicmaker.factory

import musicmaker.ChordSequence
import musicmaker.Chord

class ChordSequenceFactory {

    static ChordSequence createRandomSequence(int numberOfChords) {
        ChordSequence chordSequence = new ChordSequence();
        (1..numberOfChords).each { chordSequence.add(Chord.random) }
        chordSequence
    }

}
