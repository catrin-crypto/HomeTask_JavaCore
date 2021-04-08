package lesson6;

public class Cat extends Animal{
    private static int catsCount;
    public static final int catMaxDistance = 200;
    public Cat(String name) {
        super(name);
        catsCount++;
    }

    public static int getCatsCount() {
        return catsCount;
    }

    @Override
    public void run(int distanceInMeters) {
        if(distanceInMeters > catMaxDistance){
            distanceInMeters = catMaxDistance;
        }
        super.run(distanceInMeters);

    }

    @Override
    public void swim(int distanceInMeters) {

        System.out.println(name + " can't swim.");
    }
}
