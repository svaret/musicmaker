package musicmaker

import musicmaker.factory.ChordSequenceFactory
import musicmaker.factory.RandomWordFactory
import musicmaker.factory.ToneSequenceFactory
import org.bson.types.ObjectId

class Song {
    ObjectId id
    String title
    Riff intro
    Verse verse
    Chorus chorus
    Riff outro

    Song(int numberOfIntroNotes, int numberOfVerseChords, int numberOfChorusChords, int numberOfOutroNotes) {
        title = RandomWordFactory.pickFromWebService() + " " + RandomWordFactory.pickAmongTuneWords()
        intro = new Riff(ToneSequenceFactory.createRandomToneSequence(numberOfIntroNotes))
        verse = new Verse(ChordSequenceFactory.createRandomSequence(numberOfVerseChords))
        chorus = new Chorus(ChordSequenceFactory.createRandomSequence(numberOfChorusChords))
        outro = new Riff(ToneSequenceFactory.createRandomToneSequence(numberOfOutroNotes))
    }
}
