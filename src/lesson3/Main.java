package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static final int MAX_TRY_COUNT = 3;//max number of attempts to guess the number
    public static void main(String[] args) {
        Random random = new Random();
        int userDecision;

    do
    {

        int guessingNumber = random.nextInt(10);

        //int maxTryCount = 3;

        for (int tryCount = MAX_TRY_COUNT; tryCount > 0; tryCount--)
        {
            System.out.println("Угадайте число от 0 до 9");
            int userAnswer = scanner.nextInt();
            if(userAnswer == guessingNumber)
            {
                System.out.println("Вы угадали!");
                break;
            }else if(userAnswer > guessingNumber)
            {
                System.out.println("Загаданное число меньше");
            }else
            {
                System.out.println("Загаданное число больше");
            }
            if(tryCount == 1)
            {
                System.out.println("Попытки закончились. Вы проиграли!");
            }
        }
        System.out.println("Хотите сыграть ещё раз? Если да, то введите 1, если нет, то 0");
        userDecision = scanner.nextInt();
    } while(userDecision == 1);




    GuessWordGame.runGame();
        scanner.close();
    }
}
