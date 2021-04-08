package lesson6;

public class Cat extends Animal{
    private static int catsCount;
    public Cat(String name) {
        super(name);
        catsCount++;
    }

    public static int getCatsCount() {
        return catsCount;
    }

    @Override
    public void run(int distanceInMeters) {
        if(distanceInMeters > 200){
            distanceInMeters = 200;
        }
        super.run(distanceInMeters);

    }

    @Override
    public void swim(int distanceInMeters) {

        System.out.println(name + " can't swim.");
    }
}
