package lesson5.race.car;

import lesson5.race.track.Race;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;

import static lesson5.MainClass.notificationsInTheRace;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static final ArrayBlockingQueue messageSequence = new ArrayBlockingQueue(1);

    static {
        CARS_COUNT = 0;
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
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            notificationsInTheRace.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (messageSequence.offer(this.name)) {
                System.out.println(this.name + " WIN!!!");
            }
            try {
                notificationsInTheRace.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }

}
