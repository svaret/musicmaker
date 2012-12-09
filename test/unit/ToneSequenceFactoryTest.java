package unit;

import musicmaker.ToneSequence;
import musicmaker.ToneSequenceFactory;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class ToneSequenceFactoryTest {

    @Test
    public void createRandomToneSequenceShouldContainCorrectNumberOfTones() {
        int numberOfTones = 4;
        ToneSequence toneSequence = ToneSequenceFactory.createRandomSequence(numberOfTones);
        assertEquals(numberOfTones, toneSequence.getTones().size());
    }

}
