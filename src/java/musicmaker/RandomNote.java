package musicmaker;

public class RandomNote {

    private String[] notes;
    public String name;

    public RandomNote() {
        populateNotes();
        name = getRandomNote();
    }

    public String getRandomNote() {
        return notes[RandomNumber.getRandomNumber(notes.length)];
    }

    private void populateNotes() {
        notes = new String[12];
        Tone[] tones = Tone.A.getDeclaringClass().getEnumConstants();

        int i = 0;
        for (Tone tone : tones) {
            notes[i] = tone.toString();
            i++;
        }
    }

}
