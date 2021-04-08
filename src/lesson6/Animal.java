package lesson6;

public class Animal {
    protected String name;
    private static int animalsCount;

    public static int getAnimalsCount() {
        return animalsCount;
    }

    public Animal(String name) {
        this.name = name;
        animalsCount++;
    }

    public void run(int distanceInMeters){
        System.out.println(name + " ran " + distanceInMeters + "m.");
    }
    public void swim(int distanceInMeters){
        System.out.println(name + " swam " + distanceInMeters + "m.");
    }

}
