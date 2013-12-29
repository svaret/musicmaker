package musicmaker
import static musicmaker.factory.RandomWordFactory.pickAmongTuneWords
import static musicmaker.factory.RandomWordFactory.pickFromWebService;

class Lyrics {
    List<String> words


    Lyrics(List<String> words) {
        this.words = words
    }


    Lyrics(int noOfWords) {

        List<String> tmp  = new ArrayList<String>();

        for(int i = 0; i < noOfWords; i++){
            if ( i % 2 == 0 )
                tmp[i] = pickAmongTuneWords();
            else
                tmp[i] = pickFromWebService();
         }

        this.words = tmp
    }
}
