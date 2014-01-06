package musicmaker

import grails.test.mixin.TestFor
import spock.lang.Specification

//@TestFor(WordClass)
class WordClassTest extends Specification {

    def setup() {
    }

    def "Call to WordClass.getRandom should return a wordClass "() {
        given:

        when: "running getRandom"
        WordClass w = WordClass.getRandom()

        then: "expect a wordClass"
        w in WordClass
    }
}





