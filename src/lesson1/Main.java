package lesson1;

public class Main {
    static float a = (float) 3.6;
    public static void main(){
        byte number = -100;
        short number1 = 0;
        int x = 22;
        long y = 214748349L;
        double z = 123.48;
        char symbol = 'B';
        boolean result = true;
    }

    public static float doCalc(float b, float c, float d){
        float result = a * (b + (c / d));
        return result;
    }

    public static boolean compareTwoNumbers(int x, int y){
        int sum = x + y;
        if(sum >= 10 && sum<= 20){
            return true;
        }else return false;
    }

    public static void checkIfPositive(int x){
        if(x >= 0){
            System.out.println("Number is positive");
        }else System.out.println("Number is negative");
    }
    public static boolean checkIfNegative(int y){
        if(y < 0){
            return true;
        }else return false;
    }
    public static void sayHello(String name){
        System.out.println("Привет, " + name + "!");
    }
    public static void yearDefinition(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println("Год является високосным.");
        }else System.out.println("Год не является високосным.");
    }
}
