package musicmaker;

public class ChordSequenceFactory {

    public static ChordSequence createRandomSequence(int numberOfChords) {
        ChordSequence chordSequence = new ChordSequence();
        for (int i = 0; i < numberOfChords; i++)
            chordSequence.add(Chord.getRandom());

        return chordSequence;
    }
}
