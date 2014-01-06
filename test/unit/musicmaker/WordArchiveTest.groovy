package musicmaker

import grails.test.mixin.TestFor
import spock.lang.Specification

import static musicmaker.WordClass.ADJECTIVE
import static musicmaker.WordClass.ADVERB
import static musicmaker.WordClass.CONJUNCTION
import static musicmaker.WordClass.DETERMINER
import static musicmaker.WordClass.PREPOSITON
import static musicmaker.WordClass.VERB
import static musicmaker.WordClass.NOUN

@TestFor(WordArchive)
class WordArchiveTest extends Specification {

    def setup() {
    }

    def "created word archive should contain words of all word classes"() {
        when:
        def wordArchive = new WordArchive()
        then:
        wordArchive.VERB_STRINGS.size() > 0
        wordArchive.NOUN_STRINGS.size() > 0
        wordArchive.ADJECTIVE_STRINGS.size() > 0
        wordArchive.ADVERB_STRINGS.size() > 0
        wordArchive.CONJUNCTION_STRINGS.size() > 0
        wordArchive.DETERMINER_STRINGS.size() > 0
        wordArchive.PREPOSITION_STRINGS.size() > 0
    }

    def "getVerb should return Verb"() {
        when:
        def wordArchive = new WordArchive()
        Word word = wordArchive.getRandomVerb()

        then:
        word.wordClass == VERB
    }

    def "getRandomNoun should return Noun"() {
        when:
        def wordArchive = new WordArchive()
        Word word = wordArchive.getRandomNoun()

        then:
        word.wordClass == NOUN
    }

    def "getRandomDeterminer should return Determiner"() {
        when:
        def wordArchive = new WordArchive()
        Word word = wordArchive.getRandomDeterminer()

        then:
        word.wordClass == DETERMINER
    }

    def "getRandomAdjective should return Adjective"() {
        when:
        def wordArchive = new WordArchive()
        Word word = wordArchive.getRandomAdjective()

        then:
        word.wordClass == ADJECTIVE
    }

    def "getRandomAdVerb should return Adverb"() {
        when:
        def wordArchive = new WordArchive()
        Word word = wordArchive.getRandomAdverb()

        then:
        word.wordClass == ADVERB
    }

    def "getRandomPreposition should return Preposition"() {
        when:
        def wordArchive = new WordArchive()
        Word word = wordArchive.getRandomPreposition()

        then:
        word.wordClass == PREPOSITON
    }

    def "getRandomConjunction should return Conjunction"() {
        when:
        def wordArchive = new WordArchive()
        Word word = wordArchive.getRandomConjunction()

        then:
        word.wordClass == CONJUNCTION
    }

}
