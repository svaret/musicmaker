package musicmaker;

import java.util.LinkedList;
import java.util.List;

public class ChordSequence {
	List<Chord> chords = new LinkedList<Chord>() {};

    public void add(Chord chord) {
        chords.add(chord);
    }

    public List<Chord> getChords() {
        return chords;
    }
 
 }	
