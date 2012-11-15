package musicmaker;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Song {

	private final String[] availableNotes = { "C", "C#", "D", "D#", "E", "F",
			"F#", "G", "G#", "A", "A#", "B" };

	private enum ChordColor {
		major, minor
	};

	private String title;
	private String intro;
	private List<String> verseChords;
	private List<String> chorusChords;
	private String outro;
	
	Song(int numberOfNotesInIntro, int numberOfChordsInVerse, int numberOfChordsInChorus,
			int numberOfNotesInOutro) {
		Ititle t = new Title();
		title = t.getTitle(2);
		intro = makeIntroOutro(numberOfNotesInIntro);
		verseChords = makeVerseChorus(numberOfChordsInVerse);
		chorusChords = makeVerseChorus(numberOfChordsInChorus);
		outro = makeIntroOutro(numberOfNotesInOutro);
	}

	private List<String> makeVerseChorus(int i) {
		List<String> chords = new LinkedList<String>();
		for (int j = 0; j < i; j++) {
			String chord = getRandomNote() + " " + getChordColor();
			chords.add(chord);
		}
		return chords;
	}

	private String getChordColor() {
		Random randomGenerator = new Random();

		boolean minor = randomGenerator.nextBoolean();
		if (minor == false)
			return ChordColor.minor.toString();
		else
			return "";// ChordColor.major.toString());
	}

	private String makeIntroOutro(int i) {
		String introOutro = new String();
		for (int j = 0; j < i; j++) {
			introOutro = introOutro + getRandomNote() + " ";
		}
		return introOutro;
	}

	private String getRandomNote() {
		return availableNotes[RandomNumber.getRandomNumber(availableNotes.length)];
	}


	public String createTitleOld() {
		List<String> l = new LinkedList<String>();

		try {
			FileInputStream fstream = new FileInputStream("Words.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				l.add(strLine);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String title = l.get(RandomNumber.getRandomNumber(l.size())) + " "
				+ l.get(RandomNumber.getRandomNumber(l.size()));

		return title;
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

	public String getCompleteSongStringHtmlFormat() {
		String rs = new String();
		// Title
		rs = " <h1><u>" + title + "</u><br>";
		// for (int i = 0; i < title.length(); i++) {
		// rs = rs + "--";
		// }
		rs = rs + "<br>";

		// Add Intro
		rs = rs + "Intro: <br>" + intro + "<br><br>";

		// Add Verse
		rs = rs + "Verse: <br>";
		for (int i = 0; i < verseChords.size(); i++) {
			rs = rs + verseChords.get(i);
			if (i != verseChords.size() - 1)
				rs = rs + ", ";
		}
		rs = rs + "<br><br>";

		// Add Chorus
		rs = rs + "Chorus: <br>";
		for (int i = 0; i < chorusChords.size(); i++) {
			rs = rs + chorusChords.get(i);
			if (i != chorusChords.size() - 1)
				rs = rs + ", ";
		}

		rs = rs + "<br><br>";

		// Add outro
		rs = rs + "Outro: <br>" + outro + "</h1>";

		return rs;
	}

	

}
