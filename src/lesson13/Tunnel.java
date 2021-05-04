package lesson13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore enterTunnel;
    public Tunnel(int totalRacersCount) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.enterTunnel = new Semaphore(totalRacersCount / 2,true);
    }
    @Override
    public void go(Car car) {
        try {
            try {
                System.out.println(car.getName() + " готовится к этапу(ждет): " + description);
                enterTunnel.acquire();
                System.out.println(car.getName() + " начал этап: " + description);
                Thread.sleep(length / car.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(car.getName() + " закончил этап: " + description);
                enterTunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}