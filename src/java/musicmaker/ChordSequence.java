package musicmaker;

import java.util.LinkedList;
import java.util.List;

public class ChordSequence {
	List<String> chords = new LinkedList<String>() {};

 	public ChordSequence(int numberOfChords) {
        for (int j = 0; j < numberOfChords; j++) {
            String chord = new Chord().name;
            chords.add(chord);
        }
	}
 }	
