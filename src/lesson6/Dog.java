package lesson6;

public class Dog extends Animal{
    private static int dogsCount;
    public static final int DOG_MAX_DISTANCE = 500;
    public static final int DOG_MAX_SWIM_DISTANCE = 10;
    public Dog(String name) {
        super(name);
        dogsCount++;
            }

    public static int getDogsCount() {
        return dogsCount;
    }

    @Override
    public void run(int distanceInMeters) {
        if(distanceInMeters > DOG_MAX_DISTANCE){
            distanceInMeters = DOG_MAX_DISTANCE;
        }
        super.run(distanceInMeters);
    }

    @Override
    public void swim(int distanceInMeters) {
        if(distanceInMeters > DOG_MAX_SWIM_DISTANCE){
            distanceInMeters = DOG_MAX_SWIM_DISTANCE;
        }
        super.swim(distanceInMeters);
    }
}
