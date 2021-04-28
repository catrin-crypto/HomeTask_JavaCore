package lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = ArrayToArrayList(new Integer[]{5, 4, 3, 2, 1});
        GenericArray<Integer> testArrList = new GenericArray(arrList);
        testArrList.ExchangeElements(0, 4);
        System.out.println(testArrList);


        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        box1.addFruit(orange1);
        box1.addFruit(apple1);
        box2.addFruit(orange2);
        box3.addFruit(apple2);
        box1.merge(box3);
        box1.merge(box2);
    }

    public static ArrayList<Integer> ArrayToArrayList(Integer[] intArray) {
        return new ArrayList(Arrays.asList(intArray));
    }


}
