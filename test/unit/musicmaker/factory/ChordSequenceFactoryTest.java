package musicmaker.factory;
 

import musicmaker.ChordSequence;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ChordSequenceFactoryTest {

    @Test
    public void createRandomSequenceShouldContainCorrectNumberOfChords() {
        int numberOfChords = 4;
        ChordSequence chordSequence = ChordSequenceFactory.createRandomSequence(numberOfChords);

        assertEquals(numberOfChords, chordSequence.getChords().size());
    }

}
