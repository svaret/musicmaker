package musicmaker;

public class ToneSequenceFactory {

    public static ToneSequence createRandomSequence(int numberOfTones) {
        ToneSequence toneSequence = new ToneSequence();
        for (int i = 0; i < numberOfTones; i++)
            toneSequence.add(Tone.getRandom());

        return toneSequence;
    }
}
