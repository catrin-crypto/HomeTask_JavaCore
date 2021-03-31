package lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessWordGame {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static String[] wordsArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                                        "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato", };
    public static String resultChars;//final word with guessed letters & sharps
    public static final int WORD_MAX_LENGTH = 15;//sharps max length
    public static void runGame()
    {
        String guessingWord = wordsArray[random.nextInt(wordsArray.length)];//ai chosen word
        do {
            System.out.println("Try to guess the word ->");
            String userAnswer = scanner.nextLine();//user input of word
            if(userAnswer.equals(guessingWord))
            {
                System.out.println("Awesome! You won!");
                break;
            }else
                {
                    resultChars = "";//cleaning of final string
                    int maxLength = guessingWord.length() > userAnswer.length() ? //compare words length and choose the least
                                    userAnswer.length() : guessingWord.length();

                for (int i = 0; i < maxLength; i++)//must iterate letters from ai guessingWord
                                                                // and compare with letters from userAnswer
                {
                    char letter = userAnswer.charAt(i);//pushing letters from userAnswer into char letter
                    if(Character.toLowerCase(letter) == Character.toLowerCase(guessingWord.charAt(i)))
                    {
                        resultChars += letter;
                    }else {
                        resultChars += "#";

                    }
                }
                for(int i = maxLength; i < WORD_MAX_LENGTH; i++)//filling rest of resultChars with sharps
                {
                    resultChars += "#";
                }
                System.out.println(resultChars);
                    System.out.println("One more try");
            }
        }while (true);
        scanner.close();
    }

}
