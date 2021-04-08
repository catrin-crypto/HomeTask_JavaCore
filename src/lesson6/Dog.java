package lesson6;

public class Dog extends Animal{
    private static int dogsCount;
    public static final int dogMaxDistance = 500;
    public static final int dogMaxSwimDistance = 10;
    public Dog(String name) {
        super(name);
        dogsCount++;
            }

    public static int getDogsCount() {
        return dogsCount;
    }

    @Override
    public void run(int distanceInMeters) {
        if(distanceInMeters > dogMaxDistance){
            distanceInMeters = dogMaxDistance;
        }
        super.run(distanceInMeters);
    }

    @Override
    public void swim(int distanceInMeters) {
        if(distanceInMeters > dogMaxSwimDistance){
            distanceInMeters = dogMaxSwimDistance;
        }
        super.swim(distanceInMeters);
    }
}
