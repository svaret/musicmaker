package musicmaker;

import java.util.LinkedList;
import java.util.List;
 

public class Song {
    String[] notes; 
	private Title title;
	private String intro;
	private List<String> verseChords;
	private List<String> chorusChords;
	private String outro;
	
	Song(int numberOfNotesInIntro, int numberOfChordsInVerse, int numberOfChordsInChorus,
		int numberOfNotesInOutro) {		  
		title = TitleFactory.createTitle();
        intro = new Riff(numberOfNotesInIntro).toneSequence;
        verseChords = new ChordSequence(numberOfChordsInVerse).chords;
	    chorusChords = new ChordSequence(numberOfChordsInChorus).chords;
	    outro = new Riff(numberOfNotesInOutro).toneSequence;
	}
 
 

    public String createCompleteSongStringHtmlFormat() {
        String rs = new String();
        rs = addTitleHtml();
        rs = addIntroHtml(rs);
        rs = addVerseHtml(rs);
        rs = addChorusHtml(rs);
        rs = addOutroHtml(rs);
        return rs;
    }

	private String addOutroHtml(String rs) {
		rs = rs + "Outro: <br>" + outro + "</h1>";
		return rs;
	}

	private String addChorusHtml(String rs) {
		rs = rs + "Chorus: <br>";
        for (int i = 0; i < chorusChords.size(); i++) {
            rs = rs + chorusChords.get(i);
            if (i != chorusChords.size() - 1)
                rs = rs + ", ";
        }
        rs = rs + "<br><br>";
		return rs;
	}

	private String addIntroHtml(String rs) {
		rs = rs + "Intro: <br>" + intro + "<br><br>";
		return rs;
	}

	private String addTitleHtml() {
		String rs;
		rs = " <h1><u>" + title.generate() + "</u><br>";
        rs = rs + "<br>";
		return rs;
	}

	private String addVerseHtml(String rs) {
		rs = rs + "Verse: <br>";
        for (int i = 0; i < verseChords.size(); i++) {
            rs = rs + verseChords.get(i);
            if (i != verseChords.size() - 1)
                rs = rs + ", ";
        }
        rs = rs + "<br><br>";
		return rs;
	}
}
