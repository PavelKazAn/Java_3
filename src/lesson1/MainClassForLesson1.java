package lesson1;

import lesson1.bigTask.Box;
import lesson1.bigTask.fruit.Apple;
import lesson1.bigTask.fruit.Orange;

import java.util.ArrayList;

public class MainClassForLesson1 {
    public static void main(String[] args) {
        int[] arrInt = {1, 2, 3, 4, 5};

        swap(arrInt, 2, 3);

        for (int i : arrInt) {
            System.out.println("i = " + i);
        }
        // Конец первого задания.

        ArrayList<Integer> arrayList = convertingArrayToArrayList(arrInt);

        for (Integer integer : arrayList) {
            System.out.println("integer = " + integer);
        }
        // Конец второго задания

        Box<Orange> orangeBox = new Box<>(new Orange());
        Box<Apple> appleBox = new Box<>(new Apple());

        orangeBox.add(new Orange());
        appleBox.add(new Apple());

        orangeBox.addMoreFruit(new Orange(),6);
        appleBox.addMoreFruit(new Apple(),9);

        System.out.println("orangeBox.getWeight() = " + orangeBox.getWeight());
        System.out.println("appleBox.getWeight() = " + appleBox.getWeight());

        System.out.println("orangeBox.compare(orangeBox) = " + orangeBox.compare(appleBox));
        // Конец третьего задания.
    }
    private static ArrayList<Integer> convertingArrayToArrayList(int[] arrInt) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : arrInt) {
            arrayList.add(i);
        }
        return arrayList;
    }

    private static void swap(int[] arrInt, int firstNumber, int secondNumber) {
        int number = arrInt[firstNumber];
        arrInt[firstNumber] = arrInt[secondNumber];
        arrInt[secondNumber] = number;
    }


}
