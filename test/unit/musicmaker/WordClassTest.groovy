package musicmaker

import spock.lang.Specification

//@TestFor(WordClass)
class WordClassTest extends Specification {

    def setup() {
    }

    def "Call to WordClass.getRandom should return a wordClass "() {
        when: "running getRandom"
        WordClass w = WordClass.getRandom()

        then: "expect a wordClass"
        w in WordClass
    }
}





