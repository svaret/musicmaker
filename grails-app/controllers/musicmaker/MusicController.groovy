package musicmaker

class MusicController {
    private static final int INTRO_NOTES = 2
    private static final int NUMBER_OF_CHORDS_IN_VERSE = 5
    private static final int NUMBER_OF_CHORDS_IN_CHORUS = 3
    private static final int NUMBER_OF_NOTES_IN_OUTRO = 12

    def index() {
        Song song = new Song(INTRO_NOTES, NUMBER_OF_CHORDS_IN_VERSE, NUMBER_OF_CHORDS_IN_CHORUS,
                NUMBER_OF_NOTES_IN_OUTRO);
        def songInView = song.createCompleteSongStringHtmlFormat();
        [songInView: songInView]
    }

}
