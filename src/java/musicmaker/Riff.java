package musicmaker;

public class Riff {

	String toneSequence = "";

	public Riff(int numberOfNotes) {     
        for (int j = 0; j < numberOfNotes; j++) {
        	toneSequence = toneSequence + new RandomNote().name + " ";
        }		
	}
}
