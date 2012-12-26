package musicmakerr

import musicmaker.Tone
import musicmaker.ToneSequence
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class ToneSequenceTests {
    @Test
    void toneSequenceShouldContainOneMoreToneAfterAdd() {
        def toneSequence = new ToneSequence()
        def numberOfTonesBefore = toneSequence.size
        toneSequence.add(Tone.A)

        assertEquals numberOfTonesBefore + 1, toneSequence.size
    }
}
