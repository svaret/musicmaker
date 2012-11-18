package musicmaker;

import java.util.List;

public class Verse {

    private ChordSequence chordSequence;

    public Verse(ChordSequence chordSequence) {
        this.chordSequence = chordSequence;
    }

    public List<Chord> getChords() {
        return chordSequence.getChords();
    }
}
