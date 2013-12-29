package musicmaker

import static musicmaker.factory.RandomWordFactory.pickAmongTuneWords
import static musicmaker.factory.RandomWordFactory.pickFromWebService

class Lyrics {
    List<String> words = new ArrayList<>()

    Lyrics(int numberOfWords) {
        for (int i = 0; i < numberOfWords; i++) {
            if (i % 2 == 0)
                words[i] = pickAmongTuneWords()
            else
                words[i] = pickFromWebService()
        }
    }
}