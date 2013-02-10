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
    private static final String MUSICMAKER_DB = "musicmaker"

    def mongo

    def create() {
        def db = mongo.getDB(MUSICMAKER_DB)
        db.song.insert([title: request.JSON.title])

        def result = [status: "OK"]
        render result as JSON
    }

    def read() {
        def id = params.id
        def db = mongo.getDB(MUSICMAKER_DB)
        if (id != null)
            render com.mongodb.util.JSON.serialize(db.song.findOne(_id: new ObjectId(id)))
        else
            render com.mongodb.util.JSON.serialize(db.song.find())
    }

    def random() {
        Song song = new Song(NUMBER_OF_NOTES_IN_INTRO, NUMBER_OF_CHORDS_IN_VERSE,
                NUMBER_OF_CHORDS_IN_CHORUS, NUMBER_OF_NOTES_IN_OUTRO)
        SongView songView = new SongView(song)
        def jsonBuilder = new JsonBuilder()
        jsonBuilder.setContent(songView)
        def db = mongo.getDB(MUSICMAKER_DB)
        def json = jsonBuilder.toString()
        db.song.insert(com.mongodb.util.JSON.parse(json))

        render songView as JSON
    }

    def update() {
        def id = params.id
        def title = request.JSON.title
        def db = mongo.getDB(MUSICMAKER_DB)
        db.song.update([_id: new ObjectId(id)], [$set: [title: title]])

        def result = [status: "OK"]
        render result as JSON
    }

    def delete() {
		def id = params.id
        def db = mongo.getDB(MUSICMAKER_DB)
		if (id == null)
			db.song.remove([:])
        else
			db.song.remove(_id: new ObjectId(id))
		def result = [status: "OK"]
        render result as JSON
    }
}