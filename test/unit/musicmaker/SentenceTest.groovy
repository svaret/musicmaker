package musicmaker

import org.junit.Test
import musicmaker.Sentence
import spock.lang.Specification

//@TestFor(Sentence)
class SentenceTest extends Specification {

    def setup() {
    }

    @Test
    def "getTextSencentce should return string consisting of 5 words equals 4 blanks"(){
        given:

        when:
        Sentence sentence = new Sentence()

        then:
        sentence.wordString.contains(" ")       //TODO: Den här kollar ju bara på ett balksteg!

    }

    @Test
    def "When creating a Sentence expect a result containing 6 words. "() {
        given:

        when:
        Sentence sentence = new Sentence()

        then:
        sentence.words.size == 6



    }

    @Test
    def "PWhen creating a Sentence the sentence should contian capital first letter and point at the end. "() {
        given:

        when:
        Sentence sentence = new Sentence()

        then:
        char c = sentence.wordString[sentence.wordString.length()]
        c == "."

    }

}






