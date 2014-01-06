package musicmaker

enum WordClass {
    VERB, NOUN, DETERMINER, ADJECTIVE, ADVERB, PREPOSITON, CONJUNCTION
    private static final WORD_CLASSES = values()
    private static final SIZE = WORD_CLASSES.size()
    private static final Random RANDOM = new Random()

    static WordClass getRandom() {
        WORD_CLASSES[RANDOM.nextInt(SIZE)]
    }
}




