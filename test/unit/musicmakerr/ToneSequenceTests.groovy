package musicmakerr

import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class ToneSequenceTests {
    @Test
    void toneSequenceShouldContainOneMoreToneAfterAdd() {
        def toneSequence = new ToneSequence()
        def numberOfTonesBefore = toneSequence.getSize()
        toneSequence.add(Tone.A)

        assertEquals numberOfTonesBefore + 1, toneSequence.getSize()
    }
}