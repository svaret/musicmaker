package musicmaker

class SongView {
    String title
    List<String> intro
    List<String> verse
    List<String> chorus
    List<String> outro

    SongView(Song song) {
        title = song.title
        intro = song.intro.tones.collect{ it.label }
        verse = song.verse.chords.collect{ it.label }
        chorus = song.chorus.chords.collect{ it.label }
        outro = song.outro.tones.collect{ it.label }
    }
}
