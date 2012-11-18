package musicmaker;

public enum Chord {
    C, C_SHARP("C#"), D, D_SHARP("D#"), E, F, F_SHARP("F#"), G, G_SHARP("G#"), A, A_SHARP("A#"), B;

    public String label;

    Chord(String label) {
        this.label = label;
    }

    Chord() {
        this.label = name();
    }

    public int size() {
        return values().length;
    }

    public String toString() {
        return label;
    }
}

