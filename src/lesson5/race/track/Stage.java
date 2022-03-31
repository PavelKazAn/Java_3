package lesson5.race.track;

import lesson5.race.car.Car;

public abstract class Stage {

    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}