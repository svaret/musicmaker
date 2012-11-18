package musicmaker;

import java.security.SecureRandom;

public class ChordSequenceFactory {

    public static ChordSequence createRandomSequence(int numberOfChords) {
        ChordSequence chordSequence = new ChordSequence();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < numberOfChords; i++) {
            int randomInt = Math.abs(secureRandom.nextInt());
            int chordValueIndex = randomInt % (Chord.values().length - 1);
            Chord chord = Chord.values()[chordValueIndex];
            chordSequence.add(chord);
        }
        return chordSequence;
    }
}
