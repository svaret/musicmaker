package musicmaker;

public enum Tone {
    C,
    CSHARP {
        public String toString() {
            return "C#";
        }
    },
    D,
    DSHARP {
        public String toString() {
            return "D#";
        }
    },
    E,
    F,
    FSHARP {
        public String toString() {
            return "F#";
        }
    },
    G,
    GSHARP {
        public String toString() {
            return "G#";
        }
    },
    A,
    ASHARP {
        public String toString() {
            return "A#";
        }
    },
    B
}


