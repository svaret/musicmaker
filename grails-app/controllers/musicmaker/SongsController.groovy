package musicmaker

import com.mongodb.BasicDBObject
import com.mongodb.DBCollection
import com.mongodb.DBObject
import grails.converters.JSON
import grails.converters.XML
import groovy.json.JsonBuilder
import org.bson.types.ObjectId

class SongsController {
    private static final int NUMBER_OF_NOTES_IN_INTRO = 2
    private static final int NUMBER_OF_CHORDS_IN_VERSE = 5
    private static final int NUMBER_OF_CHORDS_IN_CHORUS = 3
    private static final int NUMBER_OF_NOTES_IN_OUTRO = 12

    def mongo

    def show() {
        def db = mongo.getDB("musicmaker")
        String idString = "5106e1ec0364cfa1d16c7bc3";
        DBCollection coll = db.getCollection("song");
        DBObject searchById = new BasicDBObject("_id", new ObjectId(idString));
        DBObject found = coll.findOne(searchById);
        withFormat {
            json { render com.mongodb.util.JSON.serialize(db.song.find()) }
        }
    }

    def random() {
        Song song = new Song(NUMBER_OF_NOTES_IN_INTRO, NUMBER_OF_CHORDS_IN_VERSE,
                NUMBER_OF_CHORDS_IN_CHORUS, NUMBER_OF_NOTES_IN_OUTRO)
        SongView songView = new SongView(song)
        def builder = new JsonBuilder()
        builder.setContent(songView)
        def db = mongo.getDB("musicmaker")
        db.song.insert(com.mongodb.util.JSON.parse(builder.toString()))
        withFormat {
            xml { render songView as XML }
            json { render songView as JSON }
        }
    }

    def list() {
        def db = mongo.getDB("musicmaker")
        withFormat {
          json { render com.mongodb.util.JSON.serialize(db.song.find().limit(8)) }
        }
    }
	
	def dropDatabase() {
		def db = mongo.getDB("musicmaker")
        db.song.remove([:])
	}
}