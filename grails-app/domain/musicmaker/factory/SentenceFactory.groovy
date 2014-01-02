package musicmaker.factory

class SentenceFactory {

    private static final RANDOM = new Random()

    static def getSentence() {

       String sentence;
       String[] sentencePattern = getSentencePattern()

       int i;
       for(i=0; i++; i < sentencePattern.length){
           if (sentencePattern[i] =="V")
             sentence = sentence + " " + Verbs[RANDOM.nextInt(Verbs.size)]
           if (sentencePattern[i] =="N")
               sentence = sentence + " " + Nouns[RANDOM.nextInt(Nouns.size)]
           if (sentencePattern[i] =="D")
               sentence = sentence + " " + Determiners[RANDOM.nextInt(Determiners.size)]
           if (sentencePattern[i] =="ADJ")
               sentence = sentence + " " + Adjectives[RANDOM.nextInt(Adjectives.size)]
           if (sentencePattern[i] =="ADV")
               sentence = sentence + " " + Adverbs[RANDOM.nextInt(Adverbs.size)] + " "
           if (sentencePattern[i] =="P")
               sentence = sentence + " " + Preposition[RANDOM.nextInt(Preposition.size)]
           if (sentencePattern[i] =="C")
               sentence = sentence + " " + Conjunction[RANDOM.nextInt(Conjunction.size)]

       }
        return sentence

       /*
       Verbs[RANDOM.nextInt(Verbs.size)] + " " +
       Nouns[RANDOM.nextInt(Nouns.size)] + " " +
       Determiners[RANDOM.nextInt(Determiners.size)] + " " +
       Adjectives[RANDOM.nextInt(Adjectives.size)] + " " +
       Adverbs[RANDOM.nextInt(Adverbs.size)] + " " +
       Preposition[RANDOM.nextInt(Preposition.size)] + " " +
       Conjunction[RANDOM.nextInt(Conjunction.size)]
        */
    }

    private static final Verbs = ["accept", "add", "admire", "admit", "advise", "afford", "agree", "alert", "allow", "amuse", "analyse", "announce", "annoy", "answer", "apologise", "appear", "applaud", "appreciate", "approve", "argue", "arrange", "arrest", "arrive", "ask", "attach", "attack", "attempt", "attend", "attract", "avoid", "back", "bake", "balance", "ban", "bang", "bare", "bat", "bathe", "battle", "beam", "beg", "behave", "belong", "bleach", "bless", "blind", "blink", "blot", "blush", "boast", "boil", "bolt", "bomb", "book", "bore", "borrow", "bounce", "bow", "box", "brake", "branch", "breathe", "bruise", "brush", "bubble", "bump", "burn", "bury", "buzz", "calculate", "call", "camp", "care", "carry", "carve", "cause", "challenge", "change", "charge", "chase", "cheat", "check", "cheer", "chew", "choke", "chop", "claim", "clap", "clean", "clear", "clip", "close", "coach", "coil", "collect", "colour", "comb", "command", "communicate", "compare", "compete", "complain", "complete", "concentrate", "concern", "confess", "confuse", "connect", "consider", "consist", "contain", "continue", "copy", "correct", "cough", "count", "cover", "crack", "crash", "crawl", "cross", "crush", "cry", "cure", "curl", "curve", "cycle", "dam", "damage", "dance", "dare", "decay", "deceive", "decide", "decorate", "delay", "delight", "deliver", "depend", "describe", "desert", "deserve", "destroy", "detect", "develop", "disagree", "disappear", "disapprove", "disarm", "discover", "dislike", "divide", "double", "doubt", "drag", "drain", "dream", "dress", "drip", "drop", "drown", "drum", "dry", "dust", "earn", "educate", "embarrass", "employ", "empty", "encourage", "end", "enjoy", "enter", "entertain", "escape", "examine", "excite", "excuse", "exercise", "exist", "expand", "expect", "explain", "explode", "extend", "face", "fade", "fail", "fancy", "fasten", "fax", "fear", "fence", "fetch", "file", "fill", "film", "fire", "fit", "fix", "flap", "flash", "float", "flood", "flow", "flower", "fold", "follow", "fool", "force", "form", "found", "frame", "frighten", "fry", "gather", "gaze", "glow", "glue", "grab", "grate", "grease", "greet", "grin", "grip", "groan", "guarantee", "guard", "guess", "guide", "hammer", "hand", "handle", "hang", "happen", "harass", "harm", "hate", "haunt", "head", "heal", "heap", "heat", "help", "hook", "hop", "hope", "hover", "hug", "hum", "hunt", "hurry", "identify", "ignore", "imagine", "impress", "improve", "include", "increase", "influence", "inform", "inject", "injure", "instruct", "intend", "interest", "interfere", "interrupt", "introduce", "invent", "invite", "irritate", "itch", "jail", "jam", "jog", "join", "joke", "judge", "juggle", "jump", "kick", "kill", "kiss", "kneel", "knit", "knock", "knot", "label", "land", "last", "laugh", "launch", "learn", "level", "license", "lick", "lie", "lighten", "like", "list", "listen", "live", "load", "lock", "long", "look", "love", "man", "manage", "march", "mark", "marry", "match", "mate", "matter", "measure", "meddle", "melt", "memorise", "mend", "messup", "milk", "mine", "miss", "mix", "moan", "moor", "mourn", "move", "muddle", "mug", "multiply", "murder", "nail", "name", "need", "nest", "nod", "note", "notice", "number", "obey", "object", "observe", "obtain", "occur", "offend", "offer", "open", "order", "overflow", "owe", "own", "pack", "paddle", "paint", "park", "part", "pass", "paste", "pat", "pause", "peck", "pedal", "peel", "peep", "perform", "permit", "phone", "pick", "pinch", "pine", "place", "plan", "plant", "play", "please", "plug", "point", "poke", "polish", "pop", "possess", "post", "pour", "practise", "pray", "preach", "precede", "prefer", "prepare", "present", "preserve", "press", "pretend", "prevent", "prick", "print", "produce", "program", "promise", "protect", "provide", "pull", "pump", "punch", "puncture", "punish", "push", "question", "queue", "race", "radiate", "rain", "raise", "reach", "realise", "receive", "recognise", "record", "reduce", "reflect", "refuse", "regret", "reign", "reject", "rejoice", "relax", "release", "rely", "remain", "remember", "remind", "remove", "repair", "repeat", "replace", "reply", "report", "reproduce", "request", "rescue", "retire", "return", "rhyme", "rinse", "risk", "rob", "rock", "roll", "rot", "rub", "ruin", "rule", "rush", "sack", "sail", "satisfy", "save", "saw", "scare", "scatter", "scold", "scorch", "scrape", "scratch", "scream", "screw", "scribble", "scrub", "seal", "search", "separate", "serve", "settle", "shade", "share", "shave", "shelter", "shiver", "shock", "shop", "shrug", "sigh", "sign", "signal", "sin", "sip", "ski", "skip", "slap", "slip", "slow", "smash", "smell", "smile", "smoke", "snatch", "sneeze", "sniff", "snore", "snow", "soak", "soothe", "sound", "spare", "spark", "sparkle", "spell", "spill", "spoil", "spot", "spray", "sprout", "squash", "squeak", "squeal", "squeeze", "stain", "stamp", "stare", "start", "stay", "steer", "step", "stir", "stitch", "stop", "store", "strap", "strengthen", "stretch", "strip", "stroke", "stuff", "subtract", "succeed", "suck", "suffer", "suggest", "suit", "supply", "support", "suppose", "surprise", "surround", "suspect", "suspend", "switch", "talk", "tame", "tap", "taste", "tease", "telephone", "tempt", "terrify", "test", "thank", "thaw", "tick", "tickle", "tie", "time", "tip", "tire", "touch", "tour", "tow", "trace", "trade", "train", "transport", "trap", "travel", "treat", "tremble", "trick", "trip", "trot", "trouble", "trust", "try", "tug", "tumble", "turn", "twist", "type", "undress", "unfasten", "unite", "unlock", "unpack", "untidy", "use", "vanish", "visit", "wail", "wait", "walk", "wander", "want", "warm", "warn", "wash", "waste", "watch", "water", "wave", "weigh", "welcome", "whine", "whip", "whirl", "whisper", "whistle", "wink", "wipe", "wish", "wobble", "wonder", "work", "worry", "wrap", "wreck", "wrestle", "wriggle", "x-ray",   "yawn", "yell", "zip", "zoom" ]
    private static final Nouns = ["brother", "car", "David", "house", "London"]
    private static final Determiners = ["a", "an", "my", "some", "the"]
    private static final Adjectives = ["big", "foolish", "happy", "talented", "tidy","adaptable", "adventurous", "affable", "affectionate", "agreeable", "ambitious", "amiable", "amicable", "amusing", "brave", "bright", "broad-minded", "calm", "careful", "charming", "communicative", "compassionate", "conscientious", "considerate", "convivial", "courageous", "courteous", "creative", "decisive", "determined", "diligent", "diplomatic", "discreet", "dynamic", "easygoing", "emotional", "energetic", "enthusiastic", "exuberant", "fair-minded", "faithful", "fearless", "forceful", "frank", "friendly", "funny", "generous", "gentle", "good", "gregarious", "hard-working", "helpful", "honest", "humorous", "imaginative", "impartial", "independent", "intellectual", "intelligent", "intuitive", "inventive", "kind", "loving", "loyal", "modest", "neat", "nice", "optimistic", "passionate", "patient", "persistent", "pioneering", "philosophical", "placid", "plucky", "polite", "powerful", "practical", "pro-active", "quick-witted", "quiet", "rational", "reliable", "reserved", "resourceful", "romantic", "self-confident", "self-disciplined", "sensible", "sensitive", "shy", "sincere", "sociable", "straightforward", "sympathetic", "thoughtful", "tidy", "tough", "unassuming", "understanding", "versatile", "warmhearted", "willing", "witty" ]
    private static final Adverbs = ["happily", "recently", "soon", "then", "there"]
    private static final Preposition =["at", "in", "of", "over", "with"]
    private static final Conjunction = ["and", "because", "but", "if", "or"]


     static def String[] getSentencePattern() {

        String[] Pattern1 = ["D", "N", "V", "ADV", "N", "D", "V", "P", "N"]
        String[] Pattern2 = ["C", "N", "V", "D", "N", "P", "N"]
        String[] Pattern3 = ["ADV", "N", "V", "N", "N", "C", "P", "N", "ADV", "ADJ"]
        String[] Pattern4 = ["P", "D", "N", "N", "V", "V", "N", "C", "D"]
        String[] Pattern5 = ["C", "N", "V", "P", "N", "P",  "N" ]

//        private final allpatterns = [Pattern1, Pattern2, Pattern3, Pattern4, Pattern5]
//        return (allpatterns[Random.nextInt(allpatterns.size)])

    }

  /*D N V ADV N D V P N
    There's a lady who's sure all that glitters is gold
    C N V D N P N
    And she's buying a stairway to heaven.
    ADV N V N N C P N ADV ADJ
    When she gets there she knows, if the stores are all closed
    P D N N V V N C D
    With a word she can get what she came for.
    C N V P N P N
    and she's buying a stairway to heaven.
   */


}
