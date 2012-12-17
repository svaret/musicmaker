package musicmaker;

import musicmaker.factory.ChordSequenceFactory;
import musicmaker.factory.RandomWordFactory;
import musicmaker.factory.ToneSequenceFactory;

public class Song {
    private String title;
    private Riff intro;
    private Verse verse;
    private Chorus chorus;
    private Riff outro;

    public Song(int numberOfIntroNotes, int numberOfVerseChords, int numberOfChorusChords, int numberOfOutroNotes) {
        title = RandomWordFactory.pickFromWebService() + " " + RandomWordFactory.pickAmongTuneWords();
        intro = new Riff(ToneSequenceFactory.createRandomSequence(numberOfIntroNotes));
        verse = new Verse(ChordSequenceFactory.createRandomSequence(numberOfVerseChords));
        chorus = new Chorus(ChordSequenceFactory.createRandomSequence(numberOfChorusChords));
        outro = new Riff(ToneSequenceFactory.createRandomSequence(numberOfOutroNotes));
    }

    public String getTitle() {
        return title;
    }

    public Riff getIntro() {
        return intro;
    }

    public Verse getVerse() {
        return verse;
    }

    public Chorus getChorus() {
        return chorus;
    }

    public Riff getOutro() {
        return outro;
    }
}