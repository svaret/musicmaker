package musicmaker

class SongView {
    String title
    String intro
    String verse
    String chorus
    String outro

    SongView(Song song) {
        this.title = song.title
        this.intro = song.intro.tones
        this.verse = song.verse.chords
        this.chorus = song.chorus.chords
        this.outro = song.outro.tones
    }
}
