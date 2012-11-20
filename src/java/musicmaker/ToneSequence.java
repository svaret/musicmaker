package musicmaker;

import java.util.LinkedList;
import java.util.List;

public class ToneSequence {
    List<Tone> tones = new LinkedList<Tone>() {};

    public void add(Tone tone) {
        tones.add(tone);
    }

    public List<Tone> getTones() {
        return tones;
    }

}
