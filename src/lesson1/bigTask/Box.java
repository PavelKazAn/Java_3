package lesson1.bigTask;

import lesson1.bigTask.fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> box = new ArrayList<>();
    private T fruits;

    public Box(T fruit) {
        this.fruits = fruit;
    }

    public void add(T fruit){
        box.add(fruit);
    }

    public void addMoreFruit(T fruit,int number){
        for (int i = 0; i < number; i++) {
            this.add(fruit);
        }
    }

    public float getWeight(){
        float weight = 0.0f;
        for (T oneFruit : box) {
            weight += oneFruit.getWeight();
        }
        return weight;
    }

    public void transferTo(Box<T> secondBox){
        for (T fruit : box) {
            secondBox.add(fruit);
        }
        box.clear();
    }

    public boolean compare (Box<?> secondBox){
        return Math.abs(getWeight() - secondBox.getWeight()) < 0.00001;
    }
}
