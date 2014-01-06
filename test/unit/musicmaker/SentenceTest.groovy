package musicmaker

import spock.lang.Specification

//@TestFor(WordClass)
class SentenceTest extends Specification {

    def setup() {
    }

    def "When creating a Sentence expect a result containing 6 words. "() {
        given:

        when:
        Sentence sentence = new Sentence()

        then:
        sentence.words.size == 6

        (0..5).each {
           it in Word
        }
    }
}





