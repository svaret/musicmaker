package musicmaker.factory

import musicmaker.Sentence

class SentenceFactory {
    static List<Sentence> createSentences(int numberOfSentences) {
        List<Sentence> sentences = []
        (1..numberOfSentences).each {
            sentences << new Sentence()
        }
        sentences
    }
}
