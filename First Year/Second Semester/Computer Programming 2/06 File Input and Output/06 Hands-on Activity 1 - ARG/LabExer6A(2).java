import java.io.*; // Importing IO package for InputStream and other related classes
import java.util.*; // Importing the util package for the Random and Scanner class
import java.nio.file.*; // Importing the file package from the nio package for the Path and other related classes

public class LabExer6A {

    // Initializes a static Scanner object to get user inputs
    private final static Scanner scannerObject = new Scanner(System.in);

    // Gets the words.txt file from the file system
    private final static Path wordsTextFile = Paths.get("words.txt");

    /* Gets a string array that consist of 2 variations of the
    random word to guess which are the correct word and the
    version of the word that has questions marks randomly
    inserted into the word. */
    private final static String[] randomWord = getRandomWord();

    // Stores the random word which of consist of question marks
    private final static String randomWordToGuess = randomWord[0];

    // Stores the random which does not consist of question marks
    private final static String randomWordCorrect = randomWord[1];

    // Main method of the program
    public static void main(String[] args) {
        // Prints out the name of the program and the word that the user has to guess
        System.out.println("Word Guessing Game!!");
        System.out.println("The word to guess is " + randomWordToGuess);

        // Starts the program
        startWordGame();
    }

    /* The core part of the program which handles the user's input,
    checking if the letters matched, changing the questions marks
    to the correct letters if the letters matched and checking
    if the user has guessed the word correctly. */
    private static void startWordGame() {

        /* Stores the random word with that consists of questions marks
        and converts it into an array of characters. */
        char[] charArrFromWordToGuess = randomWordToGuess.toCharArray();

        /* Creates an infinite loop which can only end if the user
        has guessed the random word correctly. */
        do {
            // Request for user input and converts the word into all uppercase
            System.out.print("Guess the word: ");
            String guess = scannerObject.nextLine().toUpperCase();

            try {
                // If the input is empty, it will throw a BlankAnswerException
                if (guess.isEmpty()) {
                    throw new BlankAnswerException();
                }
            } catch (BlankAnswerException bae) {
                System.out.println(bae.getMessage());
                // Will restart the guessing game process
                startWordGame();
            }

            // Creates a loop which is dependent on the user input's word's length
            for (int i = 0; i<guess.length(); i++) {

                // A try catch block for checking exceptions
                try {

                    /* If the length of the user's input does not match the
                    word to be guessed then it will throw an exception
                    called ArrayIndexOutOfBoundsException because the
                    length of the user's input does not equal to the word. */
                    if (guess.length() > randomWordCorrect.length() || guess.length() < randomWordCorrect.length()) {
                        throw new ArrayIndexOutOfBoundsException("Error: Guess does not match the length");
                    }

                    /* Checks for each individual characters of the user's input using
                    the index of the for loop above and the random word's correct
                    variation, if they do not match then the program will inform
                     the user that the letter does not belong to the word itself. */
                    if (guess.charAt(i) != randomWordCorrect.charAt(i)) {
                        System.out.println("Letter " + guess.charAt(i) + " is not in the word.");
                    }

                    /* Checks if the character in the random word with question marks
                    variation is a question mark or not. */
                    if (charArrFromWordToGuess[i] == '?') {

                        /* Checks for each character from the user's input and if
                        it does match with the correct letter then it will
                        substitute the question mark in that current with
                        the correct letter.  */
                        if (guess.charAt(i) == randomWordCorrect.charAt(i)) {
                            charArrFromWordToGuess[i] = randomWordCorrect.charAt(i);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    /* If the program encounters this exception, it will print
                    out that the user's input length is too long for the
                    random word which the user has to match and guess
                    then restarts the request for user input. */
                    System.out.println(e.getMessage());
                    startWordGame();
                }
            }

            /* Finally, if the user has guessed the word correctly, it will print out a
            congratulatory message and will break the loop resulting the end of the program. */
            if (randomWordCorrect.equalsIgnoreCase(String.valueOf(charArrFromWordToGuess))) {
                System.out.println("Great job! The word was " + randomWordCorrect.toLowerCase() + "!!");
                System.exit(0);
            } else {
                /* If the user's guess does not match with the correct word, it will loop back
                while printing out the word that the user has to guess again but with some
                of the letters being substituted if some letters are guessed correctly. */
                System.out.println("Try again, the word is " + String.valueOf(charArrFromWordToGuess));
            }
        } while (true);
    }

    // Generates and returns a random integer from the Random class
    private static int generateRandomNumber(int value) {
        Random random = new Random();
        return random.nextInt(value);
    }

    /* Generates the 2 variations of the random word which are the correct one
    and the variation with the question marks and stores them in an
    array of string and returns them to the randomWord string array variable. */
    private static String[] getRandomWord() {
        /* Initializes a random number from the generateRandomNumber function
        and puts in the number of words of the words file which is
        generated from the getNumberOfWords function then stores it. */
        int randomWordNumber = generateRandomNumber(getNumberOfWords());

        /* Initializes two strings which stores the same random word from
        the getWordsList function, one string will be the correct variant
        and the other one will be the one that will question marks. */
        String wordToGuess = getWordsList()[randomWordNumber];
        String correctWord = getWordsList()[randomWordNumber];

        /* Initializes a number from the picked random word then gets
        its length then divides it by 3 to get the average integer
        and that will be the frequency used for generating question
        marks in the random word. */
        int randomWordLength = wordToGuess.length() / 3;

        // Loops through all the letters of the random word
        for (int i = 0; i!=randomWordLength; i++) {

            // Gets a random letter from the random word
            int randomPosition = generateRandomNumber(wordToGuess.length());

            /* Checks if the letter is a question mark
            will repeat the loop if it is a question mark. */
            if (wordToGuess.charAt(randomPosition) == '?') {
                continue;
            }

            // If the letter is not a question mark then it will replace that letter with a question mark
            wordToGuess = wordToGuess.replace(wordToGuess.charAt(randomPosition), '?');
        }
        // Returns both variations of the random word (With question marks, Correct one)
        return new String[]{wordToGuess, correctWord};
    }

    /* Retrieves all the words in the words list text file then stores it in an array
    * of strings then returns it to the getRandomWord function. */
    private static String[] getWordsList() {
        // Initializes an array of string called wordsList then sets it to null
        String[] wordsList = null;
        // Initializes integers for the index and number of words in the words file
        int index = 0, numberOfWords = getNumberOfWords();
        try {
            // BufferedReader called wordsListReader for reading all the words inside the words file
            BufferedReader wordsListReader = getBufferedReader();

            /* Assigns the wordsList array string variable size to how many
            number of words inside the words file */
            wordsList = new String[numberOfWords];

            // String variable called word that will store the word from the BufferedReader
            String word;
            while ((word = wordsListReader.readLine()) != null) {
                // Stores the word from the index into the wordsList array string variable
                wordsList[index] = word;
                // Moves to next word by incrementing one the index variable
                index++;
            }

            // Closes the BufferedReader after reading all the words
            wordsListReader.close();
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
        // Returns the wordsList array string variable
        return wordsList;
    }

    // Integer return type function that returns the number of words inside the words file
    private static int getNumberOfWords() {
        // Initializes an integer called numberOfWords and sets it to zero
        int numberOfWords = 0;
        try {
            /* Creates a BufferedReader instance that will be
            used to read the number of words inside the words file */
            BufferedReader numberOfWordsReader = getBufferedReader();
            while (numberOfWordsReader.readLine() != null) {
                // For each word read it will increment the numberOfWords variable by one
                numberOfWords++;
            }

            // After counting all words inside the words file, it will close the BufferedReader
            numberOfWordsReader.close();
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
        // Returns the numberOfWords integer variable
        return numberOfWords;
    }

    // Function that will return a BufferedReader that reads the words file
    private static BufferedReader getBufferedReader() {
        // Creates a BufferedReader reference and sets it to null
        BufferedReader bufferedReader = null;
        try {
            /* Create a InputStream instance and uses the wordsTextFile
            path and the read function for the StandardOpenOption class */
            InputStream inputStream = new BufferedInputStream(Files.newInputStream(LabExer6A.wordsTextFile, StandardOpenOption.READ));
            /* Sets the BufferedReader to a new BufferedReader instance
            and uses the newly created input stream instance */
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Returns the BufferedReader object
        return bufferedReader;
    }
}