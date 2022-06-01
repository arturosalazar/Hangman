public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        
        /*
            Task 1 - Pick a random word from the array of possible guesses
        */
        
        //Turn the word-to-guess into an array that we can iterate over
        String randomWordToGuess = randomWord(words);
        char[] wordToGuessArr = randomWordToGuess.toCharArray();

        /*
            Task 2 - Create an array for placeholder chars (which will get revealed with correct guesses)
            Display the correct number of placeholder characters with printPlaceHolder
        */
        
        char[] placeHolderArr = new char[wordToGuessArr.length];
        for (int i = 0; i < placeHolderArr.length; i++) {
            placeHolderArr[i] = '_';
        }

        //Temporary print statement for debugging
        System.out.print("Word: ");
        for (int i = 0; i < wordToGuessArr.length; i++){
            System.out.print(wordToGuessArr[i] + " ");
        }
        System.out.println();
        //End Temporary print statement for debugging

        printPlaceHolder(placeHolderArr);

    }

    public static String randomWord(String[] words) {
        //Guess a random number from 0 to the length of the array. Use to select word
        int randomChoice = (int) (Math.random() * words.length);
        String randomWord = words[randomChoice];

        return randomWord;
    }

    public static void printPlaceHolder(char[] placeHolderArr) {
        System.out.print("Word: ");
        for (int i = 0; i < placeHolderArr.length; i++){
            System.out.print(placeHolderArr[i] + " ");
        }
        System.out.println("\n");
    }

}





