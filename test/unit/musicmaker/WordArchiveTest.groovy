package musicmaker

import spock.lang.Specification

import static musicmaker.WordClass.*

class WordArchiveTest extends Specification {
    def wordArchive = new WordArchive()

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

        System.out.println("Verbs: " + wordArchive.VERB_STRINGS.size())
        System.out.println("Nouns: " + wordArchive.NOUN_STRINGS.size())
        System.out.println("Adjectives: " + wordArchive.ADJECTIVE_STRINGS.size())
        System.out.println("Adverbs: " + wordArchive.ADVERB_STRINGS.size())
        System.out.println("Conjunctions: " + wordArchive.CONJUNCTION_STRINGS.size())
        System.out.println("Determiners: " + wordArchive.DETERMINER_STRINGS.size())
        System.out.println("Prepositions: " + wordArchive.PREPOSITION_STRINGS.size())
    }



    def "getVerb should return Verb"() {
        when:
        Word word = wordArchive.getRandomVerb()

        then:
        word.wordClass == VERB
    }

    def "getRandomNoun should return Noun"() {
        when:
        Word word = wordArchive.getRandomNoun()

        then:
        word.wordClass == NOUN
    }

    def "getRandomDeterminer should return Determiner"() {
        when:
        Word word = wordArchive.getRandomDeterminer()

        then:
        word.wordClass == DETERMINER
    }

    def "getRandomAdjective should return Adjective"() {
        when:
        Word word = wordArchive.getRandomAdjective()

        then:
        word.wordClass == ADJECTIVE
    }

    def "getRandomAdVerb should return Adverb"() {
        when:
        Word word = wordArchive.getRandomAdverb()

        then:
        word.wordClass == ADVERB
    }

    def "getRandomPreposition should return Preposition"() {
        when:
        Word word = wordArchive.getRandomPreposition()

        then:
        word.wordClass == PREPOSITON
    }

    def "getRandomConjunction should return Conjunction"() {
        when:
        Word word = wordArchive.getRandomConjunction()

        then:
        word.wordClass == CONJUNCTION
    }
}