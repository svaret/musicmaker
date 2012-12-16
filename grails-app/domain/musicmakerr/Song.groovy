package musicmakerr

import musicmakerr.factory.ToneSequenceFactory
import musicmakerr.factory.ChordSequenceFactory

class Song {
    String title = "TheTitle"
    Riff intro
//    def verse
//    def chorus
//    def outro

    Song(int numberOfIntroNotes, int numberOfVerseChords, int numberOfChorusChords, int numberOfOutroNotes) {
        intro = new Riff(ToneSequenceFactory.createRandomToneSequence(numberOfIntroNotes))
//        verse = new Verse(ChordSequenceFactory.createRandomSequence(numberOfVerseChords))
//        chorus = new Chorus(ChordSequenceFactory.createRandomSequence(numberOfChorusChords))
//        outro = new Riff(ToneSequenceFactory.createRandomToneSequence(numberOfOutroNotes))
    }
}
