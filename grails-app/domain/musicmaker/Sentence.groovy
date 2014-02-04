package musicmaker

class Sentence {
    List<Word> words = []
    private WordArchive wordArchive = new WordArchive()
    public String wordString = ""

    Sentence() {
        (0..5).each {
            words << wordArchive.randomWord
        }

        for (int i; i< this.words.size(); i++){
            wordString = wordString +" "+ words[i].content
        }
        String firstLetter
        firstLetter = (String) wordString.charAt(1)
        String restOfString = wordString.substring(2)

        String firstLetterInCapital = (String) Character.toUpperCase(firstLetter.toCharacter())
        wordString = firstLetterInCapital + restOfString + "."   //TODO: Känns grisigt att skriva över wordstring då den tilldelats här ovanför
    }
}
