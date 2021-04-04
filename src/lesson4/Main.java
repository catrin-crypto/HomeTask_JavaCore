package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int maxDotCount = 0;//user's max winning combination
    public static int lineType = -1;//horizontal line=0;vertical line=1; diagonal = 2; backward diagonal=3;undefined line= -1
    public static int[] foundLineCoordinates = {0, 0}; //starting coordinates for ai next move
    public static void main(String[] args)
    {
        initMap();
        printMap();
        while (true)
        {
            humanTurn();
            printMap();
            if (checkWin(DOT_X))
            {
                System.out.println("Human won!");
                break;
            }
            //aiTurn();
            searchMostWinningCombination(DOT_X, DOT_O);
            makeBlockingMove(DOT_O);
            printMap();
            if (checkWin(DOT_O))
            {
                System.out.println("Computer won!");
                break;
            }
            if (isMapFull())
            {
                System.out.println("No winner");
                break;
            }
        }
        System.out.println("Game over");
        sc.close();
    }
    public static boolean isMapFull(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if(map[i][j] == DOT_EMPTY) return false;
            }
        } return true;
    }
    public static void aiTurn()
    {
        int x, y;
        do{
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (cellIsNotValid(x, y));
        System.out.println("Computer chose dot ->" + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn()
    {
        int x, y;
        do
            {
                System.out.println("Please insert coordinates X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (cellIsNotValid(x, y));
        map[y][x] = DOT_X;
    }
    public static boolean cellIsNotValid(int x, int y)
    {
        if(x < 0 || x >= map.length || y < 0 || y >= map.length) return true;
        return map[y][x] != DOT_EMPTY;
    }
    public static void initMap()
    {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap()
    {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean checkWin(char dot)
    {
           if (map.length > 0){
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                   if(map[i][j] == dot){
                       if (checkWinningLines(dot,i, j)) return true;
                   }
                }
            }
        } return false;

    }

    private static boolean checkWinningLines(char dot, int i, int j) {
        int leftToRightCount = 0;
        int upDownCount = 0;
        int diagonalDirectCount = 0;
        int diagonalBackwardCount = 0;
        for (int k = 1; k < DOTS_TO_WIN; k++) {
            if(j + k < map.length && map[i][j + k] == dot)
            {
                leftToRightCount++;
             }
            if(j + k < map.length && i + k < map.length && map[i + k][j + k] == dot)
            {
                diagonalDirectCount++;
            } if(i + k < map.length && map[i + k][j] == dot){
                upDownCount++;
            }
            if(j - k >= 0 && i + k < map.length && map[i + k][j - k] == dot)
            {
                diagonalBackwardCount++;
            }

        }
        if(leftToRightCount == DOTS_TO_WIN - 1 || upDownCount == DOTS_TO_WIN - 1 ||
                diagonalDirectCount == DOTS_TO_WIN - 1 || diagonalBackwardCount == DOTS_TO_WIN - 1)
        {
            return true;
        }
        return false;
    }


    public static void searchMostWinningCombination(char dot, char antiDot)
    {
        maxDotCount = 0;
        lineType = -1;
        for (int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[y].length; x++)
            {
                if(map[y][x] == dot)
                {
                    ProcessHorizontalLine(dot,antiDot, y, x);
                    ProcessVerticalLine(dot,antiDot, y, x);
                    ProcessDiagonalLine(dot,antiDot, y, x);
                    ProcessBackwardDiagonalLine(dot,antiDot, y, x);
                }
            }
        }
    }

    public static void makeBlockingMove(char antiDot)
    {
       if(isMapFull() == true)
        {
            System.out.println("No winner!");}

            if(lineType == 0)
            {
                for (int i = foundLineCoordinates[0]; i < foundLineCoordinates[0] + DOTS_TO_WIN; i++)
                {
                    if(cellIsNotValid(i, foundLineCoordinates[1]))
                    {
                        continue;
                    } else {
                        map[foundLineCoordinates[1]][i] = antiDot;
                        System.out.println("Computer blocks horizontal with move -> " + (i + 1) + " " + (foundLineCoordinates[1] + 1));
                        break;
                    }
                }
            } else if(lineType == 1)
            {
                for (int i = foundLineCoordinates[1]; i < foundLineCoordinates[1] + DOTS_TO_WIN; i++) {
                    if(cellIsNotValid(foundLineCoordinates[0], i)){
                        continue;
                    } else {
                        map[i][foundLineCoordinates[0]] = antiDot;
                        System.out.println("Computer blocks vertical with move -> " + (foundLineCoordinates[0] + 1) + " " + (i + 1));
                        break;
                    }
                }
            }
            else if(lineType == 2)
            {
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    if(cellIsNotValid(foundLineCoordinates[0] + i, foundLineCoordinates[1] + i)){
                        continue;
                    } else {
                        map[foundLineCoordinates[1] + i][foundLineCoordinates[0] + i] = antiDot;
                        System.out.println("Computer blocks diagonal with move -> " + (foundLineCoordinates[0] + i + 1) + " " + (foundLineCoordinates[1] + i + 1));
                        break;
                    }
                }
            }
            else if(lineType == 3)
            {
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    if(cellIsNotValid(foundLineCoordinates[0] - i, foundLineCoordinates[1] + i)){
                        continue;
                    } else {
                        map[foundLineCoordinates[1] + i][foundLineCoordinates[0] - i] = antiDot;
                        System.out.println("Computer blocks backward diagonal with move -> " + (foundLineCoordinates[0] - i + 1) + " " + (foundLineCoordinates[1] + i + 1));
                        break;
                    }
                }
            }else aiTurn();
        }




    private static void ProcessHorizontalLine(char dot,char antiDot,  int y, int x) {

        int leftToRightCount = 1;
        int[] startingCoordinates = {x, y};


        for (int k = 1; k < DOTS_TO_WIN; k++) {
            if(x + k < map.length && map[y][x + k] != antiDot)
            {
                if (map[y][x + k] == dot)
                {
                    leftToRightCount++;
                }
            } else {
                for (int i = 1; i <= DOTS_TO_WIN - k; i++) {
                    if(x - i >= 0 && map[y][x - i] != antiDot)
                    {
                        if(map[y][x-i] == dot)
                        {
                            leftToRightCount++;
                        }
                    } else
                    {
                        leftToRightCount = 0;
                        break;
                    }

                }
                startingCoordinates[0] -= DOTS_TO_WIN - k;
                break;
            }

            }
        if(maxDotCount < leftToRightCount)
        {
            maxDotCount = leftToRightCount;
            foundLineCoordinates = startingCoordinates;
            lineType = 0;
        }

    }

    private static void ProcessVerticalLine(char dot, char antiDot,  int y, int x) {

        int upDownCount = 1;
        int[] startingCoordinates = {x, y};
        for (int k = 1; k < DOTS_TO_WIN; k++)
        {
            if(y + k < map.length && map[y + k][x] != antiDot)
            {
                if (map[y + k][x] == dot)
                {
                    upDownCount++;
                }
            } else {
                for (int i = 1; i <= DOTS_TO_WIN - k; i++)
                {
                    if(y - i >= 0 && map[y - i][x] != antiDot)
                    {
                        if(map[y - i][x] == dot)
                        {
                            upDownCount++;
                        }
                    } else
                    {
                        upDownCount = 0;
                        break;
                    }

                }
                startingCoordinates[1] -= DOTS_TO_WIN - k;
                break;
            }

        }
        if(maxDotCount < upDownCount)
        {
            maxDotCount = upDownCount;
            foundLineCoordinates = startingCoordinates;
            lineType = 1;
        }

    }

    private static void ProcessDiagonalLine(char dot, char antiDot,  int y, int x) {

        int diagonalCount = 1;
        int[] startingCoordinates = {x, y};
        for (int k = 1; k < DOTS_TO_WIN; k++)
        {
            if(y + k < map.length && x + k < map.length && map[y + k][x + k] != antiDot)
            {
                if (map[y + k][x + k] == dot)
                {
                    diagonalCount++;
                }
            } else {
                for (int i = 1; i <= DOTS_TO_WIN - k; i++)
                {
                    if(y - i >= 0 && x - i >= 0 && map[y - i][x - i] != antiDot)
                    {
                        if(map[y - i][x - i] == dot)
                        {
                            diagonalCount++;
                        }
                    } else
                    {
                        diagonalCount = 0;
                        break;
                    }

                }
                startingCoordinates[0] -= DOTS_TO_WIN - k;
                startingCoordinates[1] -= DOTS_TO_WIN - k;
                break;
            }

        }
        if(maxDotCount < diagonalCount)
        {
            maxDotCount = diagonalCount;
            foundLineCoordinates = startingCoordinates;
            lineType = 2;
        }

    }

    private static void ProcessBackwardDiagonalLine(char dot, char antiDot,  int y, int x) {

        int backwardDiagonalCount = 1;
        int[] startingCoordinates = {x, y};
        for (int k = 1; k < DOTS_TO_WIN; k++)
        {
            if(y + k < map.length && x - k >= 0 && map[y + k][x - k] != antiDot)
            {
                if (map[y + k][x - k] == dot)
                {
                    backwardDiagonalCount++;
                }
            } else {
                for (int i = 1; i <= DOTS_TO_WIN - k; i++) {
                    if(x + i < map.length && y - i >= 0 && map[y - i][x + i] != antiDot)
                    {
                        if (map[y - i][x + i] == dot)
                        {
                            backwardDiagonalCount++;
                        }
                    } else
                    {
                        backwardDiagonalCount = 0;
                        break;
                    }

                }
                startingCoordinates[0] += DOTS_TO_WIN - k;
                startingCoordinates[1] -= DOTS_TO_WIN - k;
                break;
            }

        }
        if(maxDotCount < backwardDiagonalCount)
        {
            maxDotCount = backwardDiagonalCount;
            foundLineCoordinates = startingCoordinates;
            lineType = 3;
        }

    }




}
