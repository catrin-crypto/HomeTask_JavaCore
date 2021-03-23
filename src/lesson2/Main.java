package lesson2;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 0, 1, 1};
        if (array.length > 0){
            for(int i = 0; i < array.length; i++){
                if (array[i] == 0){
                    array[i] = 1;
                }else array[i] = 0;
//                System.out.println(array[i]);
            }
        }

    }

}
