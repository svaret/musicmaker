package musicmakerr.factory

import musicmakerr.ChordSequence
import musicmakerr.Chord

class ChordSequenceFactory {

    public static ChordSequence createRandomSequence(int numberOfChords) {
        ChordSequence chordSequence = new ChordSequence();
        (1..numberOfChords).each { chordSequence.add(Chord.getRandom()) }
        chordSequence
    }

}
