package musicmaker

public class Word {
    final String content
    final WordClass wordClass

    Word(WordClass wordClass, String content){
        this.wordClass = wordClass
        this.content = content
    }
}