package musicmakerr

import musicmakerr.factory.RandomWordFactory
import musicmakerr.factory.ToneSequenceFactory
import musicmakerr.factory.ChordSequenceFactory

class Song {
    String title = "TheTitle"
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
