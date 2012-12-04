package musicmakerr

class Riff {
    ToneSequence toneSequence

    static constraints = {}

    Riff(ChordSequence toneSequence) {
        this.toneSequence = toneSequence
    }
}
