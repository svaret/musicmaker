package musicmaker

class ToneSequence {

    def tones = []

    static constraints = {
    }

    void add(Tone tone) {
        tones.add(tone)
    }

    def getSize() {
        tones.size()
    }
}
