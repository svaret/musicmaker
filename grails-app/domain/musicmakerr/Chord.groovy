package musicmakerr

import org.apache.commons.lang.math.RandomUtils

enum Chord {
    C, C_MINOR("Cm"), C_SHARP("C#"), C_SHARP_MINOR("C#m"), D, D_MINOR("Dm"), D_SHARP("D#"), D_SHARP_MINOR("D#m"),
    E, E_MINOR("Em"), F, F_MINOR("Fm"), F_SHARP("F#"), F_SHARP_MINOR("F#m"), G, G_MINOR("Gm"), G_SHARP("G#"),
    G_SHARP_MINOR("G#m"), A, A_MINOR("Am"), A_SHARP("A#"), A_SHARP_MINOR("A#m"), B, B_MINOR("Bm")

    final String label
    static final CHORDS = values()
    static final SIZE = CHORDS.size()

    Chord(String label) {
        this.label = label
    }

    Chord() {
        label = name()
    }

    static Chord getRandom() {
        CHORDS[RandomUtils.nextInt(SIZE)]
    }

    String toString() {
        label
    }
}