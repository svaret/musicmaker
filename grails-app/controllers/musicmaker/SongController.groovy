package musicmaker

import grails.converters.JSON
import grails.converters.XML

class SongController {
    private static final int NUMBER_OF_NOTES_IN_INTRO = 2
    private static final int NUMBER_OF_CHORDS_IN_VERSE = 5
    private static final int NUMBER_OF_CHORDS_IN_CHORUS = 3
    private static final int NUMBER_OF_NOTES_IN_OUTRO = 12

    def index = {
        Song song = new Song(NUMBER_OF_NOTES_IN_INTRO, NUMBER_OF_CHORDS_IN_VERSE,
                NUMBER_OF_CHORDS_IN_CHORUS, NUMBER_OF_NOTES_IN_OUTRO)
        song.save()
        SongView songView = new SongView(song)
        withFormat {
            xml { render songView as XML }
            json { render songView as JSON }
        }
    }
	
//	blir det en getmetod här?
	def get = {
		
		}
	
}
