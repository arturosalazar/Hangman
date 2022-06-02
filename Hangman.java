import java.util.Scanner;

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

        Scanner scan = new Scanner (System.in);
        
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

        /*
            Task 3 - Create a counter variable for the user's wrong guesses and use that to display the correct gallows
            before the word to Guess
        */

        int missCounter = 0;
        //use array of size 6, because that is the max number of misses user can get
        char[] missArray = new char[6];

        boolean continueGame = true;

        while (continueGame) {
            //At the top of every turn, print everything for the user
            printGallows(missCounter);
            printWordToGuessArr(wordToGuessArr);
            printPlaceHolder(placeHolderArr);
            
            /*
            Task 4 - Show any missed guesses
            */
            printMisses(missArray);

            //Task 4.1 - ask for a guesss
            //Take in user's guess as a whole string, then simply use the first character as the guess
            System.out.print("Guess: ");
            String userGuess = scan.next();
            char userCharGuess = userGuess.charAt(0);
            //Make sure the character we compare to our words is always lower case
            userCharGuess = Character.toLowerCase(userCharGuess); 

            //Task 4.3 - Add logic to check if a letter is in the selectedWord or not 
            boolean guessCharInWord = false;
            for (int i = 0; i < wordToGuessArr.length; i++){
                //if we have a hit: 
                if (wordToGuessArr[i] == userCharGuess){
                    placeHolderArr[i] = userCharGuess;
                    guessCharInWord = true;
                }
            }

            if (guessCharInWord == false){
                missArray[missCounter] = userCharGuess;
                missCounter++;
            }

            
        }

        
        scan.close();

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

    public static void printGallows(int missCounter) {
        System.out.println(gallows[missCounter]);
    }

    public static void printMisses(char[] missArray) {
        System.out.print("Misses: ");
        for (int i = 0; i < missArray.length; i++) {
            System.out.print(missArray[i]);
        }
        System.out.println("\n");
    }

    //Temporary print function for debugging
    public static void printWordToGuessArr(char[] wordToGuessArr) {
        System.out.print("Word: ");
        for (int i = 0; i < wordToGuessArr.length; i++){
            System.out.print(wordToGuessArr[i] + " ");
        }
        System.out.println();
    }
    //End Temporary print function for debugging


}





