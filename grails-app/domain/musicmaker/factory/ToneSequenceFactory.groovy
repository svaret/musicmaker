package musicmaker.factory

import musicmaker.Tone

class ToneSequenceFactory {

    public static List<Tone> createRandomToneSequence(int numberOfTones) {
        List<Tone> tones = []
        (1..numberOfTones).each { tones << Tone.getRandom() }
        tones
    }

}
