package musicmaker

import com.mongodb.BasicDBObject
import grails.converters.JSON
import org.bson.types.ObjectId

import static com.mongodb.util.JSON.serialize

class SongsController {
    private static final int NUMBER_OF_NOTES_IN_INTRO = 2
    private static final int NUMBER_OF_CHORDS_IN_VERSE = 5
    private static final int NUMBER_OF_CHORDS_IN_CHORUS = 3
    private static final int NUMBER_OF_NOTES_IN_OUTRO = 12
    private static final String MUSICMAKER_DB = "musicmaker"

    def mongo

    def create() {
        def db = mongo.getDB(MUSICMAKER_DB)
        BasicDBObject dbObject = new BasicDBObject(request.JSON)
        db.song.insert(dbObject)
        ObjectId songId = (ObjectId) dbObject.get("_id")

        def result = [status: "OK", songId: songId.toString()]
        render result as JSON
    }

    def read() {
        def id = params.id
        def db = mongo.getDB(MUSICMAKER_DB)
        if (id != null)
            render serialize(db.song.findOne(_id: new ObjectId(id)))
        else
            render serialize(db.song.find())
    }

    def random() {
        Song song = new Song(NUMBER_OF_NOTES_IN_INTRO, NUMBER_OF_CHORDS_IN_VERSE,
                NUMBER_OF_CHORDS_IN_CHORUS, NUMBER_OF_NOTES_IN_OUTRO, "Author")
        SongView songView = new SongView(song)

        render songView as JSON
    }

    def update() {
        def id = params.id
        def db = mongo.getDB(MUSICMAKER_DB)
        db.song.update([_id: new ObjectId(id)], [$set: request.JSON])

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