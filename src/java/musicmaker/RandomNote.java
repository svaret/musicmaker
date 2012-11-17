package musicmaker;

public class RandomNote {

	private String[] notes;
	public String name;
	
	RandomNote(){
		populateNotes();
		name = getRandomNote();	
	}
	
    public String getRandomNote() {
        return notes[RandomNumber.getRandomNumber(notes.length)];
    }
	
	private void populateNotes() {
		notes = new String[12];
	    Tone[] tones = Tone.A.getDeclaringClass().getEnumConstants();
	 
	    int i = 0 ;
	    for(Tone t : tones)
		    {
		    	notes[i] = t.toString();
		    	i++;
		    }
	} 
	
}
