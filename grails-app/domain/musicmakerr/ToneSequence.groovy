package musicmakerr

class ToneSequence {

    def tones = []

    static constraints = {
    }

    def getTones() {
        tones
    }

    void add(Tone tone) {
        tones.add(tone)
    }

    def getSize() {
        tones.size()
    }
}
