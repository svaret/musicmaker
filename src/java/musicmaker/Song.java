package musicmaker;
 

public class Song {
	private Title title;
	private String intro;
	private Verse verse;
	private Chorus chorus;
	private String outro;
	
	public Song(int numberOfIntroNotes, int numberOfVerseChords, int numberOfChorusChords,
		int numberOfOutroNotes) {
		title = TitleFactory.createTitle();
        intro = new Riff(numberOfIntroNotes).toneSequence;
        ChordSequence verseChordSequence = ChordSequenceFactory.createRandomSequence(numberOfVerseChords);
        verse = new Verse(verseChordSequence);
        ChordSequence chorusChordSequence = ChordSequenceFactory.createRandomSequence(numberOfChorusChords);
        chorus  = new Chorus(chorusChordSequence);
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
        for (Chord chord : chorus.getChords()) {
            rs = rs + chord;
            rs = rs + ", ";
        }
        rs = rs.substring(0, rs.lastIndexOf(", "));
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
