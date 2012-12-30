package musicmaker

class Verse {
    static belongsTo = [song: Song]
    static hasMany = [chord: Chord]

    List chords = []

    static constraints = {}

    Verse(List<Chord> chords) {
        this.chords = chords
    }
}
