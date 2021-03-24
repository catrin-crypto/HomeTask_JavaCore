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
}
