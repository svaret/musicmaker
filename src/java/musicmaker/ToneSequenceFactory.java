package musicmaker;

import java.security.SecureRandom;

public class ToneSequenceFactory {

    public static ToneSequence createRandomSequence(int numberOfTones) {
        ToneSequence toneSequence = new ToneSequence();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < numberOfTones; i++) {
            int randomInt = Math.abs(secureRandom.nextInt());
            int toneValueIndex = randomInt % (Tone.values().length - 1);
            Tone tone = Tone.values()[toneValueIndex];
            toneSequence.add(tone);
        }

        return toneSequence;
    }
}
