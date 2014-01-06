package musicmaker

import static musicmaker.WordClass.*

class WordArchive {
    private static
    final VERB_STRINGS = ["accept", "add", "admire", "admit", "advise", "afford", "agree", "alert", "allow", "amuse", "analyse", "announce", "annoy", "answer", "apologise", "appear", "applaud", "appreciate", "approve", "argue", "arrange", "arrest", "arrive", "ask", "attach", "attack", "attempt", "attend", "attract", "avoid", "back", "bake", "balance", "ban", "bang", "bare", "bat", "bathe", "battle", "beam", "beg", "behave", "belong", "bleach", "bless", "blind", "blink", "blot", "blush", "boast", "boil", "bolt", "bomb", "book", "bore", "borrow", "bounce", "bow", "box", "brake", "branch", "breathe", "bruise", "brush", "bubble", "bump", "burn", "bury", "buzz", "calculate", "call", "camp", "care", "carry", "carve", "cause", "challenge", "change", "charge", "chase", "cheat", "check", "cheer", "chew", "choke", "chop", "claim", "clap", "clean", "clear", "clip", "close", "coach", "coil", "collect", "colour", "comb", "command", "communicate", "compare", "compete", "complain", "complete", "concentrate", "concern", "confess", "confuse", "connect", "consider", "consist", "contain", "continue", "copy", "correct", "cough", "count", "cover", "crack", "crash", "crawl", "cross", "crush", "cry", "cure", "curl", "curve", "cycle", "dam", "damage", "dance", "dare", "decay", "deceive", "decide", "decorate", "delay", "delight", "deliver", "depend", "describe", "desert", "deserve", "destroy", "detect", "develop", "disagree", "disappear", "disapprove", "disarm", "discover", "dislike", "divide", "double", "doubt", "drag", "drain", "dream", "dress", "drip", "drop", "drown", "drum", "dry", "dust", "earn", "educate", "embarrass", "employ", "empty", "encourage", "end", "enjoy", "enter", "entertain", "escape", "examine", "excite", "excuse", "exercise", "exist", "expand", "expect", "explain", "explode", "extend", "face", "fade", "fail", "fancy", "fasten", "fax", "fear", "fence", "fetch", "file", "fill", "film", "fire", "fit", "fix", "flap", "flash", "float", "flood", "flow", "flower", "fold", "follow", "fool", "force", "form", "found", "frame", "frighten", "fry", "gather", "gaze", "glow", "glue", "grab", "grate", "grease", "greet", "grin", "grip", "groan", "guarantee", "guard", "guess", "guide", "hammer", "hand", "handle", "hang", "happen", "harass", "harm", "hate", "haunt", "head", "heal", "heap", "heat", "help", "hook", "hop", "hope", "hover", "hug", "hum", "hunt", "hurry", "identify", "ignore", "imagine", "impress", "improve", "include", "increase", "influence", "inform", "inject", "injure", "instruct", "intend", "interest", "interfere", "interrupt", "introduce", "invent", "invite", "irritate", "itch", "jail", "jam", "jog", "join", "joke", "judge", "juggle", "jump", "kick", "kill", "kiss", "kneel", "knit", "knock", "knot", "label", "land", "last", "laugh", "launch", "learn", "level", "license", "lick", "lie", "lighten", "like", "list", "listen", "live", "load", "lock", "long", "look", "love", "man", "manage", "march", "mark", "marry", "match", "mate", "matter", "measure", "meddle", "melt", "memorise", "mend", "messup", "milk", "mine", "miss", "mix", "moan", "moor", "mourn", "move", "muddle", "mug", "multiply", "murder", "nail", "name", "need", "nest", "nod", "note", "notice", "number", "obey", "object", "observe", "obtain", "occur", "offend", "offer", "open", "order", "overflow", "owe", "own", "pack", "paddle", "paint", "park", "part", "pass", "paste", "pat", "pause", "peck", "pedal", "peel", "peep", "perform", "permit", "phone", "pick", "pinch", "pine", "place", "plan", "plant", "play", "please", "plug", "point", "poke", "polish", "pop", "possess", "post", "pour", "practise", "pray", "preach", "precede", "prefer", "prepare", "present", "preserve", "press", "pretend", "prevent", "prick", "print", "produce", "program", "promise", "protect", "provide", "pull", "pump", "punch", "puncture", "punish", "push", "question", "queue", "race", "radiate", "rain", "raise", "reach", "realise", "receive", "recognise", "record", "reduce", "reflect", "refuse", "regret", "reign", "reject", "rejoice", "relax", "release", "rely", "remain", "remember", "remind", "remove", "repair", "repeat", "replace", "reply", "report", "reproduce", "request", "rescue", "retire", "return", "rhyme", "rinse", "risk", "rob", "rock", "roll", "rot", "rub", "ruin", "rule", "rush", "sack", "sail", "satisfy", "save", "saw", "scare", "scatter", "scold", "scorch", "scrape", "scratch", "scream", "screw", "scribble", "scrub", "seal", "search", "separate", "serve", "settle", "shade", "share", "shave", "shelter", "shiver", "shock", "shop", "shrug", "sigh", "sign", "signal", "sin", "sip", "ski", "skip", "slap", "slip", "slow", "smash", "smell", "smile", "smoke", "snatch", "sneeze", "sniff", "snore", "snow", "soak", "soothe", "sound", "spare", "spark", "sparkle", "spell", "spill", "spoil", "spot", "spray", "sprout", "squash", "squeak", "squeal", "squeeze", "stain", "stamp", "stare", "start", "stay", "steer", "step", "stir", "stitch", "stop", "store", "strap", "strengthen", "stretch", "strip", "stroke", "stuff", "subtract", "succeed", "suck", "suffer", "suggest", "suit", "supply", "support", "suppose", "surprise", "surround", "suspect", "suspend", "switch", "talk", "tame", "tap", "taste", "tease", "telephone", "tempt", "terrify", "test", "thank", "thaw", "tick", "tickle", "tie", "time", "tip", "tire", "touch", "tour", "tow", "trace", "trade", "train", "transport", "trap", "travel", "treat", "tremble", "trick", "trip", "trot", "trouble", "trust", "try", "tug", "tumble", "turn", "twist", "type", "undress", "unfasten", "unite", "unlock", "unpack", "untidy", "use", "vanish", "visit", "wail", "wait", "walk", "wander", "want", "warm", "warn", "wash", "waste", "watch", "water", "wave", "weigh", "welcome", "whine", "whip", "whirl", "whisper", "whistle", "wink", "wipe", "wish", "wobble", "wonder", "work", "worry", "wrap", "wreck", "wrestle", "wriggle", "x-ray", "yawn", "yell", "zip", "zoom"]
    private static final NOUN_STRINGS = ["brother", "car", "David", "house", "London"]
    private static final DETERMINER_STRINGS = ["a", "an", "my", "some", "the"]
    private static
    final ADJECTIVE_STRINGS = ["big", "foolish", "happy", "talented", "tidy", "adaptable", "adventurous", "affable", "affectionate", "agreeable", "ambitious", "amiable", "amicable", "amusing", "brave", "bright", "broad-minded", "calm", "careful", "charming", "communicative", "compassionate", "conscientious", "considerate", "convivial", "courageous", "courteous", "creative", "decisive", "determined", "diligent", "diplomatic", "discreet", "dynamic", "easygoing", "emotional", "energetic", "enthusiastic", "exuberant", "fair-minded", "faithful", "fearless", "forceful", "frank", "friendly", "funny", "generous", "gentle", "good", "gregarious", "hard-working", "helpful", "honest", "humorous", "imaginative", "impartial", "independent", "intellectual", "intelligent", "intuitive", "inventive", "kind", "loving", "loyal", "modest", "neat", "nice", "optimistic", "passionate", "patient", "persistent", "pioneering", "philosophical", "placid", "plucky", "polite", "powerful", "practical", "pro-active", "quick-witted", "quiet", "rational", "reliable", "reserved", "resourceful", "romantic", "self-confident", "self-disciplined", "sensible", "sensitive", "shy", "sincere", "sociable", "straightforward", "sympathetic", "thoughtful", "tidy", "tough", "unassuming", "understanding", "versatile", "warmhearted", "willing", "witty"]
    private static final ADVERB_STRINGS = ["happily", "recently", "soon", "then", "there"]
    private static final PREPOSITION_STRINGS = ["at", "in", "of", "over", "with"]
    private static final CONJUNCTION_STRINGS = ["and", "because", "but", "if", "or"]
    private static final RANDOM = new Random()

    Word getRandomVerb() {
        new Word(VERB, VERB_STRINGS[RANDOM.nextInt(VERB_STRINGS.size)])
    }

    Word getRandomNoun() {
        new Word(NOUN, NOUN_STRINGS[RANDOM.nextInt(NOUN_STRINGS.size)])
    }

    Word getRandomDeterminer() {
        new Word(DETERMINER, DETERMINER_STRINGS[RANDOM.nextInt(DETERMINER_STRINGS.size)])
    }

    Word getRandomAdjective() {
        new Word(ADJECTIVE, ADJECTIVE_STRINGS[RANDOM.nextInt(ADJECTIVE_STRINGS.size)])
    }

    Word getRandomAdverb() {
        new Word(ADVERB, ADVERB_STRINGS[RANDOM.nextInt(VERB_STRINGS.size)])
    }

    Word getRandomPreposition() {
        new Word(PREPOSITON, PREPOSITION_STRINGS[RANDOM.nextInt(PREPOSITION_STRINGS.size)])
    }

    Word getRandomConjunction() {
        new Word(CONJUNCTION, CONJUNCTION_STRINGS[RANDOM.nextInt(CONJUNCTION_STRINGS.size)])
    }

    Word getRandomWord() {
        Word word
        WordClass wordClass = WordClass.getRandom()
        switch (wordClass) {
            case VERB: word = getRandomVerb()
                break
            case NOUN: word = getRandomNoun()
                break
            case DETERMINER: word = getRandomDeterminer()
                break
            case ADJECTIVE: word = getRandomAdjective()
                break
            case ADVERB: word = getRandomAdverb()
                break
            case PREPOSITON: word = getRandomPreposition()
                break
            case CONJUNCTION: word = getRandomConjunction()
                break
        }
        word
    }
}
