package musicmaker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Tone {
    C,
    C_SHARP("C#"),
    D,
    D_SHARP("D#"),
    E,
    F,
    F_SHARP("F#"),
    G,
    G_SHARP("G#"),
    A(),
    A_SHARP ("A#"),
    B();

    private String tone;
    private static final List<Tone> TONES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = TONES.size();
    private static final Random RANDOM = new Random();

    private Tone(String tone) {
        this.tone = tone;
    }

    private Tone() {
        this.tone = name();
    }

    public static Tone getRandom() {
        return TONES.get(RANDOM.nextInt(SIZE));
    }

    public String toString() {
        return tone;
    }
}


