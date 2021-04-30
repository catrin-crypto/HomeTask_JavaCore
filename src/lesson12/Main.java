package lesson12;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] array1 = new float[SIZE];
    static float[] array2 = new float[SIZE];

    public static void main(String[] args) {

        singleThreadProcessing();
        doubleThreadProcessing();
    }

    public static void singleThreadProcessing() {

        for (int i = 0; i < array1.length; i++) {
            array1[i] = 1;
        }
        long startingTime = System.currentTimeMillis();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("Single thread elapsed time: " + (System.currentTimeMillis() - startingTime) + "ms.");

    }


    public static void doubleThreadProcessing() {
        for (int i = 0; i < array2.length; i++) {
            array2[i] = 1;
        }
        long startingTime = System.currentTimeMillis();
        float[] firstHalf = new float[HALF];
        System.arraycopy(array2, 0, firstHalf, 0, HALF);
        float[] secondHalf = new float[HALF];
        System.arraycopy(array2, HALF, secondHalf, 0, HALF);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < firstHalf.length; i++) {
                firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < secondHalf.length; i++) {
                int ii = i + HALF;
                secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + ii / 5) * Math.cos(0.2f + ii / 5) * Math.cos(0.4f + ii / 2));
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(firstHalf, 0, array2, 0, HALF);
        System.arraycopy(secondHalf, 0, array2, HALF, HALF);

        System.currentTimeMillis();
        System.out.println("Double thread elapsed time: " + (System.currentTimeMillis() - startingTime) + "ms.");
        System.out.print("Verifying arrays...");
        boolean success = true;
        for (int i = 0; i < SIZE; i++) {
            if (array1[i] != array2[i]) {
                success = false;
                break;
            }
        }
        if (success) {
            System.out.println("success!");
        } else {
            System.out.println("failed!");
        }
    }

}
