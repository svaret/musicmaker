package musicmaker

class Chorus {
    static belongsTo = [song: Song]
    static hasMany = [chord: Chord]

    List<Chord> chords = []

    static constraints = {}

    Chorus(List<Chord> chords) {
        this.chords = chords
    }
}
