package musicmakerr

class Song {
    def intro
    def verse
    def chorus
    def outro

    Song(int numberOfIntroNotes, int numberOfVerseChords, int numberOfChorusChords, int numberOfOutroNotes) {
        intro = new Riff()
    }
}
