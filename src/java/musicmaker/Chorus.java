package musicmaker;

import java.util.List;

public class Chorus {

    private ChordSequence chordSequence;

    public Chorus(ChordSequence chordSequence) {
        this.chordSequence = chordSequence;
    }

    public List<Chord> getChords() {
        return chordSequence.getChords();
    }

}
