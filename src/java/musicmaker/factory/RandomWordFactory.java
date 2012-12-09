package musicmaker.factory;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.web.client.RestTemplate;
 

public class RandomWordFactory {

    private static final int FIRST_REAL_LETTER = 3;
    private static final int END_INDEX = 4;
    private static final int START_REST_OF_WORD = 4;

    public static String pickAmongTuneWords() {
        return tuneWords.get(new Random().nextInt(tuneWords.size()));
    }

    public static String pickFromWebService() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://randomword.setgetgo.com/get.php", String.class);
        return upperCaseFirstLetterAndRemoveLeadingGarbage(result);
    }

    private static String upperCaseFirstLetterAndRemoveLeadingGarbage(String result) {
        return result.substring(FIRST_REAL_LETTER, END_INDEX).toUpperCase() + result.substring(START_REST_OF_WORD);
    }

    private static List<String> tuneWords =
                Arrays.asList("Changes", "Wastle", "Bredon", "Coconuts", "Ned", "Margaret", "Wallflower",
                        "Rigged", "Bloomin", "Sheepfold", "James", "Lovely", "-", "3", "2", "1", "Rambling", "Buffalo",
                        "G", "A", "Kinmont", "B", "C", "N", "O", "I", "K", "T", "Q", "S", "R", "Stands", "Builder",
                        "Newsboy", "Fed", "Jolly", "Downs", "Wexford", "Bully", "Yawl", "Strutter", "Blackwood", "Few",
                        "Proud", "Marilyn", "Beliving", "Jackaro", "Davy", "John", "Month", "Althea", "Blue", "Youre",
                        "Loved", "Killer", "Robber", "Vegematic", "Jamie", "Wren", "Lovel", "Lover", "Alba", "Raleigh",
                        "Macnamaras", "Loves", "Head", "Wanna", "Hear", "Pity", "Keeper", "Wonder", "Gray", "Heat",
                        "Stream", "Wonders", "Maxwells", "Tebo", "Acres", "Caroline", "Carolina", "Mahan", "Blinds",
                        "Grey", "Grew", "Days", "Colored", "Dayn", "Tear", "Trouble", "Huron", "Skin", "Hearts", "New",
                        "Whole", "Laidley", "Nobody", "Cents", "Building", "Nuts", "Anthem", "Northern", "Villain",
                        "Roadside", "Onion", "Theyre", "Bowling", "Promusica", "Hurrah", "Wild", "Bonnie", "Jock",
                        "Will", "Coaly", "Fagan", "Evelyn", "Spencers", "Wisely", "Women", "Harper", "Godiva",
                        "Rainbow", "Elspat", "Managers", "Never", "Hymn", "Belong", "Anacreon", "Star", "Stay", "Irie",
                        "Christ", "Ground", "Waterford", "Waugh", "Cock", "Nae", "Knoxville", "Douglas", "Tell",
                        "Byebirdie", "Pretoria", "Missed", "Rantin", "Ice-hunters", "Season", "Must", "Maple",
                        "Witchcraft", "Fa!", "Iron", "Coat", "Black", "Coal", "Shouldst", "Help", "Reillys", "Lucy",
                        "Churchman", "Stem", "Joan", "Decameron", "Woman", "Cries", "Wolves", "Mcphersons", "16th",
                        "Wife", "[bob", "Joad", "Lovers", "Stew", "Faeries", "Trees", "Jordans", "Property", "Carle",
                        "Bright", "Carman", "Window", "Sisters", "Cabra", "Highway", "Christopher", "Nut", "Tinkle",
                        "Laborer", "Malarkey", "Asleep", "Holland", "Code", "Cyril", "Columbus", "Eleanors", "Ging",
                        "Money", "Garden", "Quite", "Whoa", "Would", "Upon", "Golden", "Married", "Vicar", "Lawyer",
                        "Crossing", "Theyll", "Light", "Linemans", "Eve", "Delirium", "Media", "Ditty", "Carol",
                        "Wagners", "Penny", "Liggy", "Verdi", "Lousy", "Pretty", "Ballad", "Revel", "Coulters",
                        "Durch", "Anchored", "Girl", "Once", "Nowel", "Thinnest", "Dandy-o", "Coast", "Beeton", "Poor",
                        "Skye", "Over", "Earth", "Soldier", "Cameron", "Mule", "Dealer", "Lauder", "Roses", "After",
                        "Labour", "Wamphray", "Westmorlands", "Fellow", "Weight", "Cone", "Whorl", "Ein", "Buckthorne",
                        "Bloody", "Eyed", "Coileach", "Richland", "Young", "Waters", "Kelleys", "Graham", "Eugene",
                        "Birds", "Cook", "Cool", "Unemployment", "Give", "Treks", "Hiring", "Slope", "Cold", "Tamlane",
                        "Duros", "Pink", "Muir", "Whistle", "Honky", "Pine", "Boone", "Blind", "Dangerous", "Rained",
                        "Rakes", "Brazos", "Come", "Liberty", "Keel", "Keep", "Knights", "End", "Bills", "Drooped",
                        "Much", "Remember", "Zero", "Cheese", "Won", "Campbell", "Thomas", "Jordan", "Centipede",
                        "Corn", "Billy", "Monroe", "Weiner", "Quiet", "Only", "Cost", "Nowhere", "Underneath",
                        "Jennies", "Wantin", "Boom!", "Operations", "Columbia", "Wassailing", "Lumberjacks", "Orphan",
                        "Spencer", "Diamond", "Punch", "Eyes", "Unicorn", "Cherlie", "Dances", "Cora", "Syrup", "Now",
                        "Not", "Laugh", "Kicked", "Noo", "Grampus", "Bush", "Rangers", "Rcmp", "Cross", "Elves",
                        "Cathedral", "Comical", "Who", "Thoughts", "Tragic", "Wha", "Wadna", "Janie", "Commodore",
                        "Why", "Chance", "Gentle", "Waco", "Wim", "Farmers", "Cows", "Courted", "Owre", "Infant",
                        "Twenty", "Arngosk", "Mistake", "Glasgow", "Off", "Flag", "Transit", "Cowe", "Lydia", "Hardy",
                        "Get", "Everything", "Alberta", "Oil", "Scalpaidh", "Change", "Bumm!", "Stuff", "Lumpy",
                        "Honor", "Wee", "Wildwood", "Egyptian", "Anybody", "Ended", "Clanks", "Paradise", "Gibberish",
                        "Guild", "Write", "Innisfree", "Resolution", "Creation", "Temps", "Going", "Mean", "Wall",
                        "Walk", "Viruses", "Journeyman", "Martin", "Meeting", "Delamere", "Waly", "Dade", "Vance",
                        "Industrial", "Buying", "1795", "Wake", "Macanantys", "Charming", "Cakes", "Dreamin",
                        "Farewell", "Cabin", "Gambler", "Common", "Willies", "Turkey-rogher", "Gale", "Way",
                        "Porringer", "Was", "Isle", "War", "Traveler", "Waves", "Vandy", "Wam", "Castlereagh",
                        "Magic", "Dysie", "Bordeaux", "Broomfield", "Maryanne", "Wait", "Johnsons", "Cincinatti",
                        "Cypress", "Incest", "Blooming", "Oak", "Isnt", "Drivin", "Music", "Doctor", "Gaed", "Vermont",
                        "Burning", "Cockroach", "Dodshead", "William", "Cripple", "Spain", "Mayor", "Highwayman",
                        "Mcgory", "Merry", "Cambourne", "Gap", "Rights", "Gal", "Travelin", "Gay", "Gar", "Gas",
                        "Strings", "Hildas", "Waes", "Jubilee", "These", "Cornish", "Fighting", "France", "Harry", "40",
                        "Wire", "Dale", "Out", "Our", "There", "Farmer", "Fareweel", "Rowland", "Reservist", "Wests",
                        "Buck", "Grow", "Whiskey", "Bellman", "Cheseapeake", "Ware", "Jennys", "Hooch", "With", "Hoods",
                        "Turn", "Turk", "Livith", "Wash", "Getup", "Own", "Wars", "Milkmaid", "Lighthouse", "President",
                        "Wise", "Wish", "Nellie", "Wooing", "Wing", "Wind", "Wine", "Dahn", "Clerks", "Piabba", "Leave",
                        "Bugs", "Poussie", "Cryin", "Buried", "Darktown", "Hero", "Kings", "64", "Here", "Want",
                        "Tones", "Lamentation", "Kirkcudbright", "Beechs", "Tune", "Tums", "Lifes", "Railroad",
                        "Clipper", "Sailor", "Unfortunate", "Chrysler", "[parody]", "Bogle", "Sandy", "Hobo", "Behind",
                        "Slob", "Sheep", "Data", "Lobachevsky", "Ole", "Sunny", "Old", "Sands", "Highland",
                        "Widgegoweera", "Cholesterol", "Hudson", "Crayfish", "Fly", "Whereve", "10000", "Razorback",
                        "Living", "Miller", "Dark", "Along", "Ways", "Dust", "Alone", "Nottingham", "Ludgin", "Laddy",
                        "Lundy", "One", "Teddy", "Jimmy", "Danville", "Doggie", "Bump", "Friend", "Johnson", "Sawyer",
                        "Moore", "Hoch", "Carnal", "Cousin", "Klan", "Midnight", "Precious", "Invitation", "Railway",
                        "Cottage", "Erin", "South", "Winster", "Bury", "Burd", "Lamentations", "Rooster", "Accident",
                        "Wave", "For", "Burn", "Fox", "Killarney", "Tittery", "Inclined", "Children", "Ladies",
                        "Coleraine", "Highlands", "Reynard", "Englishmen", "Hogs", "Notwork", "Follow", "Ervin",
                        "Fairy", "Ushers", "Dram", "Whale", "Do", "Stumpie", "Sign", "Daughter", "De", "Rabbit",
                        "Leroy", "Fa", "Faith", "Battle", "Twilight", "Boomerang", "Place", "Knockin", "Alley",
                        "Shannon", "Takes", "Deirdres", "Fi", "Allen", "Babylon", "Courtship", "Hold", "Walls",
                        "Casabianca", "Turpin", "Pit", "Kelly", "Whiter", "Batter", "Side", "Pig", "Colly", "Pie",
                        "Churchyard", "Home", "Juggling", "Stuart", "Holy", "Annet", "Jane", "Hole", "Athol", "At",
                        "As", "Ba", "Carrigdhoun", "Ae", "Moonshine", "Am", "An", "Escape", "By", "His", "Prodigals",
                        "Nelly", "Years", "Ca", "Looks", "Hound", "Siuler", "Be", "Colin", "Stocks", "Lancashire",
                        "Him", "Cutters", "Boat", "Those", "Battre", "Le", "Bobs", "Still", "Rebel", "Peg", "Global",
                        "La", "Hielant", "Play", "Drink", "Herbert", "Lo", "Color", "Drake", "Me", "Hieland", "Boar",
                        "Wellington", "Pagans", "Ma", "Church", "Impossible", "Stane", "Dearest", "My", "Bunch",
                        "Woods", "Sarah", "Mo", "Towns", "Thirty", "Says", "Riverboat", "Weaver", "Jail", "Na",
                        "Walter", "Goung", "Jerseywocky", "No", "Hed", "Stereo", "Hush-a-bye", "Ol", "On", "Oh", "Hey",
                        "Hen", "Of", "Hes", "Signs", "Hood", "Her", "Jones", "Go", "Tonight", "Letters", "Steamer",
                        "Maven", "Francois", "Dennis", "Something", "House", "Whitewash", "Massas", "Pal", "He", "Hi",
                        "Lovesick", "Grenadier", "Different", "Id", "If", "Stillhouse", "Bastringue", "Im", "In", "Ii",
                        "Suster", "Called", "Chicago", "Speerd", "Geordie", "Is", "It", "Iq", "Mandy", "Stair", "Jb",
                        "14th", "Begets", "Horn", "Aint", "Had", "Carroll", "Dutch", "Hae", "Horo", "Caller", "Hose",
                        "Jealous", "Hat", "Has", "Haw", "Us", "Sunshine", "Winds", "Sight", "Up", "Gold", "Donkey",
                        "Tv", "Rising", "Lights", "Hunger", "Dine", "Charley", "Gone", "Steamin", "Glow-worm", "Didnt",
                        "To", "Computer", "Drummer", "Charles", "Tonguers", "Pee-dee", "Kaw-liga", "Hamilton", "Dukes",
                        "Jonah", "Mohea", "Forgive", "Saro", "Good", "Wi", "Whiskers", "January", "We",
                        "Anti-christians", "Image", "Sumner", "Clark", "Dreamed", "Murder", "Ellenton", "Thunder",
                        "Chants", "Korea", "Maidenheid", "Faither", "Goon", "Dance", "Lias", "Chicken", "Dewey",
                        "Heard", "Bomb", "Navy", "Present", "Chroi", "Albert", "Gum", "Bone", "Sits", "Canned", "Or",
                        "Dirty", "Lamps", "Useta", "Yourself", "Salesman", "Shave", "So", "Dandelion", "Dandy",
                        "Company", "Harried", "Claud", "Keiths", "Wings", "Cindys", "Entail", "Chill", "Glasses",
                        "Wifie", "Bold", "Printers", "Warlike", "Boll", "Front", "Cigarettes", "Wished", "Child",
                        "Life", "Darby", "Whats", "Pub", "Dirge", "Speak", "Sains", "Scabsville", "Put", "Born",
                        "Avenue", "Died", "Bore", "Waste", "Around", "Whaur", "Whummil", "Hallelujah!", "Drawing",
                        "Boom", "Aggie", "Croon", "Gudewife", "Cornwall", "Spanish", "Lumber", "Sail", "Summertime",
                        "Said", "Sing", "Titanic", "Press", "Shakes", "Charlie", "Curfew", "Ye", "Tomatoes", "Holes",
                        "Viers", "Meet", "About", "Coplas", "Middle", "Vain", "Like", "Outwitted", "Pedro", "Rocks",
                        "Doctors", "Waterbound", "Masters", "Got", "Mauling", "Thessaly", "Sams", "Name",
                        "Constitutional", "Abore", "Grenada", "Lily", "God", "Sodger", "Gob", "Lang", "Lane", "Gotta",
                        "Land", "Singleton", "Lyre", "Single", "Irish", "Louisiana", "Director", "Paul", "Wakes",
                        "Leprauchan", "Country", "Fortune", "Ocoaling", "Rednecks", "Homestead", "Banks", "Chifpewa",
                        "Trains", "Ill", "Jerry", "Joanna", "Fisherman", "Bless", "Sullivan", "Redesdale", "Line",
                        "Past", "Morrow", "Lard", "Gaolach", "Lark", "Alabama", "Glory", "Rider", "Feed", "Lass",
                        "Last", "Lonnigans", "Institute", "Whatll", "Changing", "Riley", "Christening", "Feet", "Rest",
                        "Teasing", "Divide", "Yor", "You", "Hilli", "Hicks", "Julian", "Sovreign", "Iii", "Hungry",
                        "Deserter", "Hills", "Uist", "Landladys", "Daley", "	Glorious", "Reel", "Walking",
                        "Cushions", "Cinco", "Coble", "A-weepin", "California", "Provincials", "Joanie", "Cromwell",
                        "Master", "Admissions", "Randall", "Laws", "Ultimate", "Yonder", "Revenue", "Medals", "Daddy",
                        "Wallaby", "Ida", "Table", "Water", "Gute", "Walkie", "Caveat", "Lookin", "Early", "Dalby",
                        "Everywhere", "Times", "Tother", "Gods", "Live", "Candleford", "Myself", "Private", "Lazy",
                        "Maurice", "Goodnight", "Kildare", "Brouchty", "Begin", "Cards", "Ice", "Lower", "Countess",
                        "Tone", "Movement", "Fufu", "Icy", "Cuckoos", "Toms", "Puff", "Joiner", "Rhyme", "Darling",
                        "Yer", "Napoleon", "Walker", "Eagle", "Tinker", "Victory", "Tried", "Katie", "Diesel", "Smith",
                        "Working", "Hapence", "Clearances", "Whoever", "Laurel", "Shilling", "Macushla", "Test",
                        "Travelling", "Cant", "Plantation", "Tyrie", "Beer", "Cape", "Kiss", "Crow", "Dolans", "Creek",
                        "Parody", "Calling", "Distant", "Fresh", "Stockade", "Been", "Robyns", "Came", "Spinners",
                        "Pull", "Bairnie", "Weave", "Summer", "Kirk", "Johnny", "Setterday", "Marcum", "Thought",
                        "Marseillaise", "Jack", "Rae", "Katy", "Rag", "Ram", "Bailiff", "Camp", "Freud", "Kate",
                        "Glenborough", "Afterguard", "Plugole", "Gaelic", "Pretendy", "Talking", "Linplum", "Mcgee",
                        "General", "Coaling", "Franklins", "Cream", "Deacon", "Kamerad", "Cadence", "Quilting", "Call",
                        "Beichan", "Annwn", "Real", "More", "Town", "Gathering", "Lads", "Happy", "Flower", "Stars",
                        "Bathing", "Moutons", "Lawson", "Mony", "Lady", "Weavers", "Fishing", "Friendship", "Moor",
                        "Holyhead", "Moon", "Cain", "First", "Push", "Homes", "Arab", "Jacobs", "Under", "Jackhammer",
                        "Confession", "Journey", "Ginseng", "Sheela", "Glesca-lea", "Mona", "Socks", "Flowing",
                        "Birdmen", "Bouquet", "Kellswater", "Missouri", "Bell", "Cerises", "Request", "Hush", "Tailors",
                        "Roving", "Canaller", "Plow", "Night", "Husband", "Drover", "Reagan", "Canaans", "City",
                        "Tiugainn", "Cuban", "Grogan", "Gypsy", "Miner", "Queenstown", "Case", "Jockie", "Cash", "Lake",
                        "Docht", "Foyers", "Reubens", "Hundred", "Crafty", "Windings", "Piddly", "Stewart", "Proper",
                        "Cairo", "Moir", "Buttercup", "Steward", "Seamen", "Palmer", "Raftsmen", "Hoo", "Nightmare",
                        "Hot", "Eastern", "Weary", "Thank-you", "How", "Seaforths", "Disease", "Connaught", "Firing",
                        "Claude", "Dusty", "Wassail", "Western", "White", "Heathen", "Preacher", "Heather", "Robin",
                        "Care", "Wedding", "Delia", "Are", "Tiree", "Than", "Too-a-loo-ra-loo-ral", "Arc", "That",
                        "Yowe", "Ark", "King", "Awhile", "Scotch", "Stole", "Kind", "Girls", "Trooper", "Shore", "Kimo",
                        "Shanty", "Mirth", "Cabinet", "Among", "Saunders", "Cattle", "Again", "Hard", "Odouglas",
                        "Kiln", "Crawdad", "Whirly", "Ate", "Logs", "Stony", "Bessy", "Cattie", "Jenkins", "Tammy",
                        "Flowers", "Range", "Baby", "Traveller", "Little", "Stood", "Jesus", "Ucletaw", "Sausage",
                        "Hate", "Poverty", "Orion", "Lifebelt", "Harlem", "Giants", "You ", "Into", "Should", "Cyprus",
                        "Hawk", "North", "Disguise", "Pussy", "Leaves", "Horses", "Lusty", "Tuirse", "Comes", "Lament",
                        "Kyng", "Bullfight", "Have", "Lock", "Bedlam", "Story", "Your", "Its", "Sun", "Peru", "Madam",
                        "Loudon", "Howard", "Kenny", "Ive", "Tearing", "Lyke", "Match", "Beauty", "Della", "Diggers",
                        "Mountain", "Fishin", "Shadow", "Against", "Gwine", "Tea", "Hind", "Goods", "A-gallopin",
                        "Owyne", "Aye", "Hair", "Ireland", "Coulston", "Growing", "Carrion", "Daffodils", "Bulgine",
                        "Tam", "Lullaby", "Brothers", "Maggie", "Better", "Bawbee", "Hall", "Jeannie", "Tragedy",
                        "Tyne", "Goulds", "Seven", "Pieces", "Back", "Tak", "Tae", "Shimmy", "Bumm!!", "Election",
                        "Featherbed", "Cruel", "Hand", "Jesse", "Fisher", "Fishes", "Gloryland", "Jan", "Lilac",
                        "Birdie", "Peace", "Maumee", "Bag", "Type", "Bay", "Tobacco", "November", "2525", "Convict",
                        "Kidd", "Wilson", "Hill", "Chewing", "Loyal", "Hilo", "Leader", "Mockingbird", "Tocher",
                        "Ninety-eight", "Dove", "Six", "Lochmaben", "Doris", "Heywood", "Diggy", "Adair", "Cutpurses",
                        "Ranzo", "Lout", "Across", "Clayton", "Christians", "Flrst", "Breakfast", "Love", "Wear", "She",
                        "Clear", "Judgement", "Down", "Bars", "Ragged", "Court", "Topman", "Grave", "From", "Northeast",
                        "Lacadie", "Flynn", "Sit", "Bark", "Sir", "Track", "Bacon", "Sin", "Jay", "High", "Blues",
                        "Warfield", "Royal", "Gonna", "Weeper", "Tinkermans", "Dimming", "Thou", "Jim", "Slave",
                        "Drag-on", "Liverpool", "Set", "Sew", "Porter", "Sex", "Ball", "Train", "Tramping", "Kissing",
                        "Bendie", "Buvons", "Trail", "Parodies", "Watercress-o", "Reaper", "Lord", "Fragments", "Lorn",
                        "Settled", "Cockerham", "Doth", "Ramble", "Year", "Turns", "Hide", "Knowe", "Loss",
                        "Minnesotas", "Argyll", "Lost", "Tortoise-shell", "Sheppard", "Knows", "Knave", "See", "Band",
                        "Sea", "Unreconstructed", "Ago", "Evermore", "Digby", "People", "Look", "Some", "Bumm!!!",
                        "Ambulance", "Tremens", "Wayworn", "Free", "Rode", "Rock", "Stules", "Tonights", "Long", "Song",
                        "Gawaine", "Ain", "Lone", "Joseph", "Croppie", "Air", "Valley", "Widow", "Candle", "Barley",
                        "Soon", "This", "Cearc", "Sons", "Facts", "Grant", "February", "Candy", "Spy", "Agus",
                        "British", "Ladder", "Requiem", "Loom", "Queen", "Uncle", "Elem", "Queer", "Delaneys", "Could",
                        "Cargill", "Kootenays", "Oreilly", "All", "Livingston", "Father", "Laddie", "Sorrrow", "Praise",
                        "Southeast", "Tonkin", "Mccracken", "Cardrona", "Jesses", "Ribbon", "Sow", "They", "Copernicus",
                        "Son", "And", "Any", "Marian", "Count", "Samhach", "Them", "Milwaukee", "Richmond", "Island",
                        "Sky", "Cecile", "Thee", "Joe", "Ann", "Influenza", "Caterpillar", "Rebels", "Joy", "Road",
                        "Dreadful", "Delaware", "Fainey", "Calico", "America", "County", "Buain", "Drunk", "Knife",
                        "Bracken", "Dyin", "West", "Morning", "Pleasure", "Room", "But", "Prison", "Crotty", "Kinfolks",
                        "Apple", "Capital", "Bug", "Crazy", "Made", "Berry", "Watton", "Dollar", "Mulberry", "Collier",
                        "Jug", "Mamas", "Funny", "Craws", "Tree", "Rome", "Tide", "Piper", "Fatal", "Licht", "Were",
                        "Roll", "Nine", "Found", "Luther", "Lamenting", "Built", "Midwestern", "Shines", "Coming",
                        "Gilley", "Build", "Winnebacome", "Landlord", "Chain", "Herrin", "Scotland", "Cllun", "Indians",
                        "Harvey", "Claddagh", "Phone", "Cosmic", "Maid", "Tambour", "Dancing", "Carrig", "Deed",
                        "Saturday", "Horse", "Cumberland", "Mair", "Freedom", "Run", "Deep", "Twice", "Morgan",
                        "Guiding", "Rua", "Harvest", "Went", "A-begging", "Variant", "Congo", "Overlanders", "Deck",
                        "Burned", "Pumpkinville", "Chemical", "Sam", "Thyme", "Gorilla", "Mice", "Mica", "Plenty",
                        "Melville", "Kempy", "Loredo", "Well", "Dream", "Worlds", "Rochester", "Damsels", "Dean",
                        "Rogues", "Reload", "Dead", "Newfoundland", "Chant", "Dear", "Courting", "Ranger", "Saw",
                        "Sat", "Marriage", "Glass", "Trappers", "Sunnyside", "San", "Letter", "Kitchie", "Lattice",
                        "Bowl", "Tattoed", "Marlborough", "Husbandman", "Owsenford", "Blunt", "Vampire", "Rose",
                        "Thing", "Marchin", "Bothies", "Factory", "Warren", "Whaleboat", "Skinners", "Weel", "Boys",
                        "Kay", "Caledonla", "Coventry", "Cam", "Hobie", "Throw", "Lambton", "Cat", "Estmere", "Can",
                        "Clay", "Rope", "Progress", "Blanns", "Maam", "Hunting", "Vayse", "Hands", "Bedll", "Key",
                        "Reuben", "Violets", "Ken", "Lifeboat", "Preston", "Cullodens", "Forever", "Horseback",
                        "Loving", "Hawkins", "Smote", "Finger", "Ben", "Cagaran", "Pirate", "Expounded", "Mcdonnel",
                        "Agememnon", "Wallis", "Bed", "Lightning", "Bobbed", "Sister", "Craigie", "Starry", "Three",
                        "Shine", "Nobby", "Riu", "Maun", "Rig", "Ship", "Ballu", "Shall", "Greenmore", "Ships", "Dixie",
                        "Bid", "Straight", "Margery", "Uneasy", "Heaven", "Antiqua", "Miles", "Wreck", "Notes", "Dewy",
                        "Pretend", "Big", "Bit", "Arkansas", "Robert", "Servingman", "Bazaar", "Logan", "Prisoners",
                        "Legion", "Priggish", "Balou", "Glow", "Weevil", "Red", "Mayo", "Bullfrog", "Michael", "Saddle",
                        "Nancy", "Shoes", "Mckinleys", "Chesapeake", "Glen", "Hoolie", "Richards", "Gled", "Hiroshima",
                        "Vanilla", "Noble", "Hopelessly", "Man!", "York", "Iona", "Roi", "Strike", "Lesly", "Duncan",
                        "Row", "Learned", "Wednesbury", "Make", "Swear", "Chavez", "Plaidie", "Aberdeen", "Many",
                        "Calypso", "London", "Mans", "Time", "Stretched", "Dallas", "Brother", "Till", "Liddesdale",
                        "Mama", "Heres", "Lappen", "Wahoo", "Silkie", "Devil", "Retirement", "Constant", "Wagner",
                        "Twins", "Elements", "Betrayed", "Andrews", "Leesome", "Dens", "Mary", "Mars", "Clementine",
                        "Sweet", "Julie", "Winter", "View", "Sorrow", "Whalers", "Lincoln", "Mare", "Complaint",
                        "Bobbie", "Coasts", "Weeping", "Unchanging", "Boy", "Macarthys", "Sanders", "Malla", "Laird",
                        "Queensland", "Wheres", "Dress", "Leaf", "Dublin", "Near", "Tshotsholosa", "Union", "Malabar",
                        "Bosses", "Lonely", "Farm", "Mother", "Dromore", "Kleenex-ex", "Vegetable", "Work", "Bears",
                        "Lavender", "Worm", "Castle", "Deserteur", "Rovin", "Burma", "Diddle", "Drinking", "Glad",
                        "Beast", "Cuckoo", "Crossed", "Shepherd", "Tra-la-la!", "Laine", "Cut", "Turtle", "Larry",
                        "Knocka", "Steal", "Steak", "Icarus", "Turners", "Very", "Barleycorn", "Vintertime", "Visit",
                        "States", "Herrings", "Staker", "Linin", "Cup", "Derby", "Tropical", "Welcome", "Landlords",
                        "Livin", "Kennedy", "Bolyn", "Listen", "Itll", "Hatley", "Need", "Christmas", "Melancholy",
                        "Cocking", "Donalie", "Leal", "Knew", "Rover", "Riders", "Nicht", "Flora", "Earl", "Henry",
                        "Wallifou", "Trust", "Kilkelly", "Thats", "Hannah", "Fifteen", "Let", "Ballgame", "Les",
                        "Rather", "Leo", "Shamrock", "Lairdie", "Obeyed", "Incredibly", "Wariston", "Lee", "Villains",
                        "Lea", "Price", "Lindy", "Baker", "home", "Hollin", "England", "Des", "Dew", "Pride", "Legend",
                        "Surrender", "Barnards", "Parlor", "Lewis", "Baldwin", "Cheerily", "Vax", "Van", "Liver",
                        "Mouse", "Arise", "Peggie", "Mousikie", "Jennie", "Castlebar", "Cremation", "Caught", "Mourn",
                        "Wheel", "Las", "Kingwatter", "Eile", "Idlers", "Calon", "Wool", "Foot", "Lad", "Trying",
                        "Waterloo", "Lucky", "Dam", "Yarrow", "Dan", "Megan", "Shtern", "Day", "Brown", "Nell",
                        "Winchester", "Flows", "Gully", "Wont", "Ford", "Daily", "Malone", "Shepherds", "Brave",
                        "Nose", "Cadalan", "Model", "Jump", "Marquise", "Nest", "Murphy", "Clydes", "Cio", "June",
                        "Calls", "Anne", "Ferret", "Waggoner", "Bucca", "Irving", "Susie", "Garret", "Alright",
                        "Prince", "Pinder", "Willie", "Lonesome", "Unas", "Rambled", "Raspberry", "Right", "Seen",
                        "Yellow", "Scotsmans", "Hawkie", "Prime", "Chickens", "Ghost", "Ranogate", "Wager", "Gentleman",
                        "Auld", "Lie", "Lil", "Lin", "Molly", "Scouts", "Hushie", "Wakefield", "Lukeys", "Forsworn",
                        "Mind", "Mine", "Godspeed", "Puddy", "True", "Hush-a-ba", "Human", "Homeless", "Ula",
                        "Hinkumbooby", "Ramblin", "Celebrated", "David", "Mill", "Mile", "English", "Dick", "Gentlemen",
                        "Rowen", "Whitsun", "Syng", "Satchel", "Railroading", "Know", "Lum", "Through", "Things",
                        "Petrovar", "Rake", "Chauffeurs", "Voice", "Windmills", "Bucks", "Manikin", "Maria", "Truck",
                        "Nunnery", "Dan-dan-oh", "Marie", "Usa", "Dragoon", "Use", "Execution", "Send", "Judas", "Ups",
                        "Lumberjack", "Trip", "Humboldt", "Close", "Cry", "Cocaine", "Just", "Chorus", "Workhouse",
                        "Ouvriers", "Isabel", "Fields", "Judgment", "Mckean", "Macdonalds", "Rain", "Rail", "Rearguard",
                        "Feats", "Willow", "Threshing", "Pressers", "Funston", "Named", "Rivers", "Pipers", "Business",
                        "Stein", "Churchy", "Ringsend", "Today", "Clone", "Rags", "Pleasant", "Phoebe", "Noahs",
                        "Fraser", "Yonderdale", "Cob", "Low", "Prize", "Glenkindie", "Lot", "March", "Inside", "Cod",
                        "Log", "Rade", "Mist", "Australia", "Drumclog", "Noah", "Token", "Coo", "Con", "Cot", "Cow",
                        "Censorship", "Choclate", "Brigade", "Explosion", "Hielandman", "Two", "Riddles", "Fire",
                        "Chandlers", "Garners", "Jean", "Ploughboy", "Parker", "Bradford", "A-roving", "Lochleven",
                        "Mcguires", "Maccrimmons", "Patrick", "Strathmore", "Fish", "Silver", "Twa", "Theres", "Halls",
                        "Ring", "Caretaker", "Puppies", "River", "Cowboys", "Junior", "Polly", "Collycw", "Weaving",
                        "Telfer", "Trenches", "Ugliest", "Joan]", "Ephus", "Macgregors", "Coffee", "Gave", "Brig",
                        "Moorsoldaten", "Massacre", "Labourer", "Mountains", "Noblemans", "Isobel", "Five", "Ghoulie",
                        "Foolish", "Apron", "Clerk", "Dogs", "Gaun", "Another", "Saskatchewan", "Twelfth", "Cockie",
                        "Betsy", "Gregory", "Lye", "Cadgwith", "Riddle", "Radio", "Glendale", "Tooralooraloora",
                        "Matilda", "Captain", "Always", "Lowlands", "Thousand", "Peggy", "Writer", "Rise", "Tranent",
                        "Beardie", "Mists", "Before", "Keyhole", "Maidens", "Hinney", "Rindercella", "Humoresque",
                        "Ballyhooley", "Soda", "Colombe", "Men", "Ronnie", "Met", "Great", "Invented", "Away",
                        "Kelley", "Organic", "Macalister", "Twelve", "Mazlins", "Ellen", "Macpherson", "Eer", "Passage",
                        "Morrison", "Career", "Marys", "Winnebago", "Fishfinger", "Dawning", "Maryborough", "Windows",
                        "Sally", "Sleep", "Possession", "Lubberland", "Lookout", "German", "Williams", "Marry", "Brae",
                        "Gang", "Raccoon", "Elender", "Lindberg", "Highlanders", "Man", "Brisk", "Loser", "Game", "Mad",
                        "Door", "Doon", "Green", "Prayer", "Reedy", "Sings", "Gals", "Greet", "Sunday", "Suid-afrika",
                        "Rolling", "Dont", "Looking", "Dilger", "Done", "May", "Prodigal", "Donegal", "Rainich",
                        "Without", "Rattling", "Motor", "Round", "Betsey", "Luve", "Catfish", "Truckin", "Where",
                        "Workers", "Northumberland", "Lemon", "Buddies", "Pamanaw", "Babies", "Boogie", "When", "Dna",
                        "Raeburn", "Canada", "Goose", "Jamestown", "Hanford", "Major", "Death", "Mon", "Martindale",
                        "The", "1998", "Reidcap", "Broken", "World", "Abejas", "Cameronian", "Thy", "Goodman", "Brand",
                        "Worms", "Crockett", "Arthur", "Tans", "Fife", "Memory", "Fade", "Tank", "Did", "Washed",
                        "Jenny", "Patersons", "Flood", "Hung", "Alice", "Dig", "Die", "Whirley", "Refrain", "Hunt",
                        "Psalm", "Omer", "Crockery", "Butchers", "Rice", "catch", "Dornwald", "Choucoune", "23rd",
                        "Lets", "Howlin", "Therell", "Hunter", "Preferment", "Marching", "Prickilie", "Bring",
                        "Widows", "Simon", "Until", "Channel", "Birdies", "Keeping", "Touch", "Lula", "Unter", "Stormy",
                        "Knight", "Saviours", "Lasses", "Copshawholme", "Too", "Grove", "Angels", "Nostradamus", "Tom",
                        "Party", "Take", "Left", "Chester", "Marauder", "Tod", "Ride", "Tale", "Kitty", "Kilbogie",
                        "Tall", "Dapple", "1914", "Mourner", "Countrys", "Baby-o", "Fair", "Fait", "Coastline", "Dry",
                        "Conversation", "Humble", "Carried", "Elf-knight", "Bonny", "Bill", "Trolley", "Wrong",
                        "Gilheaney", "Mcsorleys", "Legged", "Derroll", "Bird", "Cotton", "Try", "Fall", "What", "False",
                        "Honest", "Divil", "Kent", "Distinction", "Fight", "Herzogin", "Lassie", "Bride", "Bells",
                        "Parted", "Hoose", "Words", "Waddles", "Nettle", "1958", "Dog", "Kemp", "Brief", "Kemo",
                        "Shackles", "Fill", "Hugh", "Paddy", "Ripple", "Tva", "Weapons", "Tub", "Drove", "Tail",
                        "Maiden", "Buckaroo");
}
