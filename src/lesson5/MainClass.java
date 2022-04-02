package lesson5;

import lesson5.race.car.Car;
import lesson5.race.track.Race;
import lesson5.race.track.Road;
import lesson5.race.track.Tunnel;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class MainClass {

    public static final int CARS_COUNT = 4;

    public static final CyclicBarrier notificationsInTheRace = new CyclicBarrier(CARS_COUNT + 1);

    public static void main(String[] args) {

        Race race = new Race(new Road(60), new Tunnel(80, CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
        messagesInTheRace();

    }

    private static void messagesInTheRace() {
        try {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            notificationsInTheRace.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            notificationsInTheRace.await();
            notificationsInTheRace.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
