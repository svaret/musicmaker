package musicmaker;

import java.util.Random;

public class Chord {
	public String name;	
 
	public Chord()
	{
		this.name = new RandomNote().name + " " + getChordColor().toString();
	} 
  
    private ChordColor getChordColor() {
        Random randomGenerator = new Random();

        boolean minor = randomGenerator.nextBoolean();
        if (minor == false)
            return ChordColor.MINOR;
        else
            return ChordColor.MAJOR;
    }	
}
