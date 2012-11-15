package musicmaker;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Song {

    private final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    private enum ChordColor {
        MAJOR {
        	public String toString() {
        		return "";
        	}
        },
        MINOR {
        	public String toString() {
        		return "minor";
        	}
        }
    };

	private Title title;
	private String intro;
	private List<String> verseChords;
	private List<String> chorusChords;
	private String outro;
	
	Song(int numberOfNotesInIntro, int numberOfChordsInVerse, int numberOfChordsInChorus,
		int numberOfNotesInOutro) {
		title = TitleFactory.createTitle();
        intro = createRiff(numberOfNotesInIntro);
        verseChords = createChordsSequence(numberOfChordsInVerse);
	    chorusChords = createChordsSequence(numberOfChordsInChorus);
	    outro = createRiff(numberOfNotesInOutro);
	} 

    private List<String> createChordsSequence(int numberOfChords) {
        List<String> chords = new LinkedList<String>();
        for (int j = 0; j < numberOfChords; j++) {
            String chord = getRandomNote() + " " + getChordColor().toString();
            chords.add(chord);
        }
        return chords;
    }

    private ChordColor getChordColor() {
        Random randomGenerator = new Random();

        boolean minor = randomGenerator.nextBoolean();
        if (minor == false)
            return ChordColor.MINOR;
        else
            return ChordColor.MAJOR;
    }

    private String createRiff(int i) {
        String introOutro = new String();
        for (int j = 0; j < i; j++) {
            introOutro = introOutro + getRandomNote() + " ";
        }
        return introOutro;
    }

    private String getRandomNote() {
        return notes[getRandomNumber(notes.length)];
    }
 
    public int getRandomNumber(int maxtal) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(maxtal);
    }

    public String createSong() {
        String song = new String();
        song = addTitle();
        song = addIntro(song);
        song = addVerse(song);
        song = addChorus(song);
        song = addOutro(song);
        return song;
    }

    private String addIntro(String rs) {
        rs = rs + "Intro: \n" + intro + "\n\n";
        return rs;
    }

    private String addTitle() {
    	String title = this.title.generate();
        String rs;
        rs = "\n" + title + "\n";
        for (int i = 0; i < title.length(); i++) {
            rs = rs + "-";
        }
        rs = rs + "\n\n";
        return rs;
    }

    private String addOutro(String rs) {
        rs = rs + "Outro: \n" + outro;
        return rs;
    }

    private String addChorus(String rs) {
        rs = rs + "Chorus: \n";
        for (int i = 0; i < chorusChords.size(); i++) {
            rs = rs + chorusChords.get(i);
            if (i != chorusChords.size() - 1)
                rs = rs + ", ";
        }

        rs = rs + "\n\n";
        return rs;
    }

    private String addVerse(String rs) {
        rs = rs + "Verse: \n";
        for (int i = 0; i < verseChords.size(); i++) {
            rs = rs + verseChords.get(i);
            if (i != verseChords.size() - 1)
                rs = rs + ", ";
        }
        rs = rs + "\n\n";
        return rs;
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
