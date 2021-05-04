package lesson13;
public class MainClass {

    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        Car.RegisterAllCarsToRaces(new RaceStartAction(),new RaceEndAction());
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }


    }
    public static class RaceStartAction implements Runnable{
        public void run(){
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
    }
    public static class RaceEndAction implements Runnable{
        public void run(){
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
}







