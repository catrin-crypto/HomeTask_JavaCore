package lesson2;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 0, 1, 1};
        if (array.length > 0){
            for(int i = 0; i < array.length; i++){
                if (array[i] == 0){
                    array[i] = 1;
                }else array[i] = 0;
                System.out.println(array[i]);
            }
        }
//        doCalc();
//        fillArray();
//        fillDiagonals();
//        findMaxMinNumber();
        //System.out.println(compareSum(myArray));

//        changeValuePosition(rotatingArray, myN);
//        for (int i = 0; i < rotatingArray.length; i++)
//            System.out.print(rotatingArray[i] + ", ");
//        System.out.println();
    }
//
    public static void fillArray() {
        int[] emptyArray = new int[8];

            for(int i = 0; i < emptyArray.length; i++) {
                emptyArray[i] = i * 3;
                System.out.println(emptyArray[i]);
            }
        }
public static void doCalc(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++){
            if (array[i] < 6){
                array[i] *= 2;
                System.out.println(array[i]);
            }
        }
}
public static void fillDiagonals(){
        int n = 6;
        int[][] doubleArray = new int[n][n];
        if (doubleArray.length > 0){
        for (int i = 0; i < doubleArray.length; i++){
            if(doubleArray[i].length > 0){
                doubleArray[i][i] = 1;
                doubleArray[i][n - 1 - i] = 1;
                for (int j = 0; j < doubleArray[i].length; j++){
                System.out.print(doubleArray[i][j] + ", ");
                }
                System.out.println();
            }
        }
        }
}
public static void findMaxMinNumber(){
        int[] array = {0, 3, 220, 15, 4, 9};
        int maxNumber = -2147483648;
        int minNumber = 2147483647;
        if (array.length > 0){
            for (int i = 0; i < array.length; i++){
                if (array[i] > maxNumber){
                    maxNumber = array[i];
                }
                if (array[i] < minNumber){
                    minNumber = array[i];
                }

            }
            System.out.println("Max number is " + maxNumber + " Min number is " + minNumber);
        }
}
   static int[] myArray = {4, 3, 3, 5, 0, 3, 2, 1, 9};
public static boolean compareSum(int [] array) {
    if (array.length > 4) //считаем, что минимально можно просуммировать по 2 элемента с каждого конца
    {
        int leftSum = array[0] + array[1];
        int rightSum = 0;
        for (int i = 2; i < array.length; i++) {
            rightSum += array[i];
        }
        if (leftSum == rightSum) {
            return true;
        }
        for (int i = 2; i < array.length - 2; i++) {
            leftSum += array[i];
            rightSum -= array[i];
            if(leftSum == rightSum){
                return true;
            }

        }
    }return false;
}
static int myN = -1;
static int[] rotatingArray = {3, 4, 1, 6, 3, 0, 8, 112};
public static void changeValuePosition(int [] array, int n)
{
    int position = 0;
    int startingPosition = position;
    int movingValue = array[position];
    for (int i = 0; i < array.length; i++)
    {
        int newPosition = (((position + n) % array.length) + array.length) % array.length;
        int oldValue = array[newPosition];
        array[newPosition] = movingValue;
        position = newPosition;
        if (position == startingPosition)
        {
            position++;
            startingPosition = position;
            movingValue = array[position];
        }
        else movingValue = oldValue;

    }

}

}
