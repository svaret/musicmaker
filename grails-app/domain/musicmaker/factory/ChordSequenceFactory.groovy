package musicmaker.factory

import musicmaker.Chord

class ChordSequenceFactory {

    static List<Chord> createRandomSequence(int numberOfChords) {
        List<Chord> chords = []
        (1..numberOfChords).each { chords.add(Chord.random) }
        chords
    }

}
