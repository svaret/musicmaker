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
// 	public ChordSequence(int numberOfChords) {
//        for (int j = 0; j < numberOfChords; j++) {
//            String chord = new Chord().name;
//            chords.add(chord);
//        }
//	}
 }	
