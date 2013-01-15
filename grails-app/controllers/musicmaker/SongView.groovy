package musicmaker

class SongView {
    String title
    String intro
    String verse
    String chorus
    String outro

    SongView(Song song) {
        title = song.title
        intro = song.intro.tones
        verse = song.verse.chords
        chorus = song.chorus.chords
        outro = song.outro.tones
    }
}
