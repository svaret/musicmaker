package musicmaker

import grails.converters.JSON
import grails.converters.XML

class SongController {
    private static final int NUMBER_OF_NOTES_IN_INTRO = 2
    private static final int NUMBER_OF_CHORDS_IN_VERSE = 5
    private static final int NUMBER_OF_CHORDS_IN_CHORUS = 3
    private static final int NUMBER_OF_NOTES_IN_OUTRO = 12

    def index = {
        def song = new musicmakerr.Song(NUMBER_OF_NOTES_IN_INTRO, NUMBER_OF_CHORDS_IN_VERSE,
                NUMBER_OF_CHORDS_IN_CHORUS, NUMBER_OF_NOTES_IN_OUTRO);
        withFormat {
            xml { render song as XML }
            json { render song.intro as JSON }
        }
    }
}
