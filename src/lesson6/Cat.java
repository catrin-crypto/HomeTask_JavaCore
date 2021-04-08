package lesson6;

public class Cat extends Animal{
    private static int catsCount;
    public static final int CAT_MAX_DISTANCE = 200;
    public Cat(String name) {
        super(name);
        catsCount++;
    }

    public static int getCatsCount() {
        return catsCount;
    }

    @Override
    public void run(int distanceInMeters) {
        if(distanceInMeters > CAT_MAX_DISTANCE){
            distanceInMeters = CAT_MAX_DISTANCE;
        }
        super.run(distanceInMeters);

    }

    @Override
    public void swim(int distanceInMeters) {

        System.out.println(name + " can't swim.");
    }
}
