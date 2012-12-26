package musicmaker

class SongView {
    String title
    String intro
    String verse
    String chorus
    String outro

    SongView(Song song) {
        this.title = song.title
        this.intro = song.intro.toneSequence.tones
        this.verse = song.verse.chordSequence.chords
        this.chorus = song.chorus.chordSequence.chords
        this.outro = song.outro.toneSequence.tones
    }
}
