package musicmaker

public class Word {
    final String content
    final WordClass wordClass

    private Word(WordClass wordClass, String content){
        this.wordClass = wordClass
        this.content = content
    }

    public static Word getRandom(){
        WordArchive wordArchive = new WordArchive()
        Word word = wordArchive.getRandomWord()
        word

     /*   WordClass wordClass = WordClass.getRandom()
        String wordContent = WordArchive.getRandomWordContent(wordClass)
        new Word(wordClass, wordContent)
      */
    }
}