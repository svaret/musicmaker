package musicmakerr

class ChordSequence {

    def chords = []

    static constraints = {
    }

    def getChords() {
        chords
    }

    void add(Chord chord) {
        chords.add(chord)
    }

    def getSize() {
        chords.size()
    }
}
