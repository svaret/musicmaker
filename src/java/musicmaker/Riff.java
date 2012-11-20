package musicmaker;

import java.util.List;

public class Riff {

	ToneSequence toneSequence;

	public Riff(ToneSequence toneSequence) {
	    this.toneSequence = toneSequence;
    }

    public List<Tone> getTones() {
        return toneSequence.getTones();
    }
}
