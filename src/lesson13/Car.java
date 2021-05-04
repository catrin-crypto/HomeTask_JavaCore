package lesson13;

import javax.management.monitor.Monitor;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static CyclicBarrier readyToStart;
    private static CyclicBarrier raceIsFinished;
    private static int CARS_COUNT;
    //private static String winningCarName;
    private static volatile AtomicBoolean isThereAWinner;

    public static void RegisterAllCarsToRaces(Runnable raceStartedAction, Runnable raceEndAction) {
        readyToStart = new CyclicBarrier(CARS_COUNT, raceStartedAction);
        raceIsFinished = new CyclicBarrier(CARS_COUNT, raceEndAction);
        //winningCarName = "";
        isThereAWinner = new AtomicBoolean(false);
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        if (readyToStart == null) {
            System.out.println(this.name + "No registration - no race!");
            return;
        }
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            readyToStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        boolean isWon = false;
//        synchronized (winningCarName){
//            if (winningCarName == "") {
//                winningCarName = name;
//                isWon = true;
//            }
//        }
        isWon = isThereAWinner.compareAndSet(false, true);
        if (isWon) {
            System.out.println(name + " is won!");
        }

        try {

            raceIsFinished.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

