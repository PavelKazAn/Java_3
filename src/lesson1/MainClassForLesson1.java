package lesson1;

import java.util.ArrayList;

public class MainClassForLesson1 {
    public static void main(String[] args) {
        int[] arrInt = {1, 2, 3, 4, 5};
        swap(arrInt, 0, 4);
        for (int i : arrInt) {
            System.out.println("i = " + i);
        }
        ArrayList<Integer> arrayList = convertingArrayToArrayList(arrInt);
        for (Integer integer : arrayList) {
            System.out.println("integer = " + integer);
        }
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
