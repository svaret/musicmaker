package musicmaker

import org.bson.types.ObjectId

import static musicmaker.factory.ChordSequenceFactory.createRandomSequence
import static musicmaker.factory.RandomWordFactory.pickAmongTuneWords
import static musicmaker.factory.RandomWordFactory.pickFromWebService
import static musicmaker.factory.ToneSequenceFactory.createRandomToneSequence

class Song {
    ObjectId id
    String title
    Riff intro
    Verse verse
    Chorus chorus
    Riff outro
	String author

    Song(int numberOfIntroNotes, int numberOfVerseChords, int numberOfChorusChords,
         int numberOfOutroNotes, String author) {
        this.title = pickAmongTuneWords() + " " + pickFromWebService()
        this.intro = new Riff(createRandomToneSequence(numberOfIntroNotes))
        this.verse = new Verse(createRandomSequence(numberOfVerseChords))
        this.chorus = new Chorus(createRandomSequence(numberOfChorusChords))
        this.outro = new Riff(createRandomToneSequence(numberOfOutroNotes))
		this.author = author
    }
}
