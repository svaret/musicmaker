package musicmaker

class Sentence {
    List<Word> words = []

    Sentence() {
        (0..5).each {
            words << Word.getRandom()
        }
    }
}
