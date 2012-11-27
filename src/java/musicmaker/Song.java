package musicmaker;

import musicmaker.factory.ChordSequenceFactory;
import musicmaker.factory.RandomWordFactory;
import musicmaker.factory.ToneSequenceFactory;

public class Song {
    private Riff intro;
    private Verse verse;
    private Chorus chorus;
    private Riff outro;

    public Song(int numberOfIntroNotes, int numberOfVerseChords, int numberOfChorusChords, int numberOfOutroNotes) {
        intro = new Riff(ToneSequenceFactory.createRandomSequence(numberOfIntroNotes));
        verse = new Verse(ChordSequenceFactory.createRandomSequence(numberOfVerseChords));
        chorus = new Chorus(ChordSequenceFactory.createRandomSequence(numberOfChorusChords));
        outro = new Riff(ToneSequenceFactory.createRandomSequence(numberOfOutroNotes));
    }

    public String createCompleteSongStringHtmlFormat() {
        return createTitleHtml() +
                createIntroHtml() +
                createVerseHtml() +
                createChorusHtml() +
                createOutroHtml();
    }

    private String createOutroHtml() {
        return "Outro: <br>" + outro.getTones() + "</h1>";
    }

    private String createChorusHtml() {
        return "Chorus: <br>" + chorus.getChords() + "<br><br>";
    }

    private String createIntroHtml() {
        return "Intro: <br>" + intro.getTones() + "<br><br>";
    }

    private String createTitleHtml() {
        return " <h1><u>" + RandomWordFactory.pickFromWebService() + " " + RandomWordFactory.pickAmongTuneWords() +
                "</u><br>" + "<br>";
    }

    private String createVerseHtml() {
        return "Verse: <br>" + verse.getChords() + "<br><br>";
    }
}