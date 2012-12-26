package musicmaker.factory

import musicmaker.ToneSequence
import musicmaker.Tone

class ToneSequenceFactory {

    public static ToneSequence createRandomToneSequence(int numberOfTones) {
        ToneSequence toneSequence = new ToneSequence();
        (1..numberOfTones).each { toneSequence.add(Tone.getRandom()) }
        toneSequence
    }

}
