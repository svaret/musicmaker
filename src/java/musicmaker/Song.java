package musicmaker;

import java.util.LinkedList;
import java.util.List;
 

public class Song {
	private Title title;
	private String intro;
	private Verse verse;
	private List<String> chorusChords;
	private String outro;
	
	public Song(int numberOfIntroNotes, int numberOfVerseChords, int numberOfChorusChords,
		int numberOfOutroNotes) {
		title = TitleFactory.createTitle();
        intro = new Riff(numberOfIntroNotes).toneSequence;
        ChordSequence verseChordSequence = ChordSequenceFactory.createRandomSequence(numberOfVerseChords);
        verse = new Verse(verseChordSequence);
	    chorusChords = new LinkedList<String>();
	    outro = new Riff(numberOfOutroNotes).toneSequence;
	}

    public String createCompleteSongStringHtmlFormat() {
        String rs = addTitleHtml();
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
        for (Chord chord : verse.getChords()) {
            rs = rs + chord;
            rs = rs + ", ";
        }
        rs = rs.substring(0, rs.lastIndexOf(", "));
        rs = rs + "<br><br>";
		return rs;
	}
}
