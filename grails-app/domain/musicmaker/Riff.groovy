package musicmaker

class Riff {
    static belongsTo = [song: Song]
    static hasMany = [tones: Tone]

    List<Tone> tones

    static constraints = {}

    Riff(List<Tone> tones) {
        this.tones = tones
    }
}
