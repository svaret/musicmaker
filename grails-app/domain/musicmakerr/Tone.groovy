package musicmakerr

enum Tone {
    C, C_SHARP("C#"), D, D_SHARP("D#"), E, F, F_SHARP("F#"), G, G_SHARP("G#"), A(), A_SHARP("A#"), B()

    private final String label
    private static final TONES = values()
    private static final SIZE = TONES.size()
    private static final Random RANDOM = new Random()

    private Tone() {
        label = name()
    }

    private Tone(String label) {
        this.label = label
    }

    static Tone getRandom() {
        TONES[RANDOM.nextInt(SIZE)]
    }

    String toString() {
        label
    }
}