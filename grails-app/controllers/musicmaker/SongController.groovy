package musicmaker

import com.gmongo.GMongo
import grails.converters.JSON
import grails.converters.XML
import groovy.json.JsonBuilder

class SongController {
    private static final int NUMBER_OF_NOTES_IN_INTRO = 2
    private static final int NUMBER_OF_CHORDS_IN_VERSE = 5
    private static final int NUMBER_OF_CHORDS_IN_CHORUS = 3
    private static final int NUMBER_OF_NOTES_IN_OUTRO = 12

    def mongo

    def index() {
        Song song = new Song(NUMBER_OF_NOTES_IN_INTRO, NUMBER_OF_CHORDS_IN_VERSE,
                NUMBER_OF_CHORDS_IN_CHORUS, NUMBER_OF_NOTES_IN_OUTRO)
        SongView songView = new SongView(song)
        def db = mongo.getDB("musicmaker")
        def builder = new JsonBuilder()
        builder.setContent(songView)
        db.song.insert(com.mongodb.util.JSON.parse(builder.toString()))
        withFormat {
            xml { render songView as XML }
            json { render songView as JSON }
        }
    }

    def list() {
        def db = mongo.getDB("musicmaker")
        withFormat {
          json { render com.mongodb.util.JSON.serialize(db.song.find()) }
        }
    }
}