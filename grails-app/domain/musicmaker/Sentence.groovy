package musicmaker

class Sentence {
    List<Word> words = []

    WordArchive wordArchive = new WordArchive()

    Sentence() {
        (0..5).each {
            words << wordArchive.randomWord
        }
    }
}
