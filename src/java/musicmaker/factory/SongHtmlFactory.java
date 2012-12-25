package musicmaker.factory;

import musicmaker.Chorus;
import musicmaker.Riff;
import musicmaker.Song;
import musicmaker.Verse;

public class SongHtmlFactory {

    public static String createCompleteSongHtml(int numberOfIntroNotes, int numberOfVerseChords,
                                                int numberOfChorusChords, int numberOfOutroNotes) {
        Song song = new Song(numberOfIntroNotes, numberOfVerseChords, numberOfChorusChords, numberOfOutroNotes);
        return createTitleHtml(song.getTitle()) +
                createIntroHtml(song.getIntro()) +
                createVerseHtml(song.getVerse()) +
                createChorusHtml(song.getChorus()) +
                createOutroHtml(song.getOutro());
    }

    private static String createChorusHtml(Chorus chorus) {
        return "Chorus: <br>" + chorus.getChords() + "<br><br>";
    }

    private static String createIntroHtml(Riff intro) {
        return "Intro: <br>" + intro.getTones() + "<br><br>";
    }

    private static String createTitleHtml(String title) {
        return " <h1><u>" + title +
                "</u><br>" + "<br>";
    }

    private static String createVerseHtml(Verse verse) {
        return "Verse: <br>" + verse.getChords() + "<br><br>";
    }

    private static String createOutroHtml(Riff outro) {
        return "Outro: <br>" + outro.getTones() + "</h1>";
    }
}
