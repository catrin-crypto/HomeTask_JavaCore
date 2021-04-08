package lesson6;

public class Dog extends Animal{
    private static int dogsCount;
    public Dog(String name) {
        super(name);
        dogsCount++;
            }

    public static int getDogsCount() {
        return dogsCount;
    }

    @Override
    public void run(int distanceInMeters) {
        if(distanceInMeters > 500){
            distanceInMeters = 500;
        }
        super.run(distanceInMeters);
    }

    @Override
    public void swim(int distanceInMeters) {
        if(distanceInMeters > 10){
            distanceInMeters = 10;
        }
        super.swim(distanceInMeters);
    }
}
