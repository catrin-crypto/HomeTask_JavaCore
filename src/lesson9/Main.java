package lesson9;

import static java.lang.Integer.parseInt;

public class Main {
    private static final String[][] MY_ARRAY_WITH_INCORRECT_LENGTH = {{"55", "Hello!"},
            {"-2", "Multiverse"},
            {"integration", "number 123"}};
    private static final String[][] MY_ARRAY_WITH_INCORRECT_DATA = {{"4", "34", "123", "0"}, {"56", "2", "908", "101"},
            {"22", "22", "222", "22222"}, {"32", "33", "Hello", "44"}};
    private static final String[][] MY_CORRECT_ARRAY = {{"4", "34", "123", "0"}, {"56", "2", "908", "101"},
            {"22", "22", "222", "22222"}, {"32", "33", "11", "44"}};
    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        try{
            System.out.println("The result: " + parseAndSumArray(MY_ARRAY_WITH_INCORRECT_LENGTH));
        } catch (MyArrayDataException | MyArraySizeException e){
            System.out.println("Caught exception: " + e.getMessage());
        }
        try{
            System.out.println("The result: " + parseAndSumArray(MY_ARRAY_WITH_INCORRECT_DATA));
        } catch (MyArrayDataException | MyArraySizeException e){
            System.out.println("Caught exception: " + e.getMessage());
        }
        try{
            System.out.println("The result: " + parseAndSumArray(MY_CORRECT_ARRAY));
        } catch (MyArrayDataException | MyArraySizeException e){
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static int parseAndSumArray(String[][] arrayToParse) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (arrayToParse.length != ARRAY_SIZE) throw new MyArraySizeException("Only array's size " + ARRAY_SIZE +
                " is allowed. Current array size is " + arrayToParse.length);
        for (int i = 0; i < arrayToParse.length; i++) {
            if (arrayToParse[i].length != ARRAY_SIZE) throw new MyArraySizeException("Only array's size " + ARRAY_SIZE +
                    " is allowed. Current array row # " + i + " size is " + arrayToParse[i].length);
            for (int j = 0; j < arrayToParse[i].length; j++) {
                try {
                    sum += parseInt(arrayToParse[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Array data parsing in cell [" + i + "][" + j +
                            "] has thrown an exception: " + e.getMessage());
                }
            }
        }
        return sum;
    }
}
