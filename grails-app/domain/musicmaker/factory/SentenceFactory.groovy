package musicmaker.factory

import groovy.json.JsonSlurper
import org.springframework.web.client.RestTemplate

class SentenceFactory {

    private static final RANDOM = new Random()

    static def getSentence() {
       Verbs[RANDOM.nextInt(Verbs.size)] + " " +
       Nouns[RANDOM.nextInt(Nouns.size)] + " " +
       Determiners[RANDOM.nextInt(Determiners.size)] + " " +
       Adjectives[RANDOM.nextInt(Adjectives.size)] + " " +
       Adverbs[RANDOM.nextInt(Adverbs.size)] + " " +
       Preposition[RANDOM.nextInt(Preposition.size)] + " " +
       Conjunction[RANDOM.nextInt(Conjunction.size)]
    }

    private static final Verbs = ["be", "drive", "grow", "sing", "think" ]
    private static final Nouns = ["brother", "car", "David", "house", "London"]
    private static final Determiners = ["a", "an", "my", "some", "the"]
    private static final Adjectives = ["big", "foolish", "happy", "talented", "tidy"]
    private static final Adverbs = ["happily", "recently", "soon", "then", "there"]
    private static final Preposition =["at", "in", "of", "over", "with"]
    private static final Conjunction = ["and", "because", "but", "if", "or"]

}
